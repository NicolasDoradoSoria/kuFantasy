package ar.edu.unsam.phm.service

import ar.edu.unsam.phm.dao.TokenRepository
import ar.edu.unsam.phm.dto.RegisterRequestDTO
import ar.edu.unsam.phm.dto.toUser
import ar.edu.unsam.phm.models.Individual
import ar.edu.unsam.phm.models.Territory
import ar.edu.unsam.phm.models.Token
import ar.edu.unsam.phm.models.User
import ar.edu.unsam.phm.utils.IndividualRole
import ar.edu.unsam.phm.utils.events.OnRegistrationCompletedEvent
import ar.edu.unsam.phm.utils.exceptions.IllegalDataException
import ar.edu.unsam.phm.utils.exceptions.InvalidCredentialsException
import ar.edu.unsam.phm.utils.exceptions.InvalidTokenException
import ar.edu.unsam.phm.utils.functions.createConfirmationOrRecoveryLink
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
class RegisterService(
  private val userService: UserService,
  private val tokenRepository: TokenRepository,
  private val territoryService: TerritoryService,
  private val eventPublisher: ApplicationEventPublisher
) {

  fun getVerificationToken(token: String): Token = tokenRepository.findByValue(token) ?: throw InvalidCredentialsException()

  @Transactional(rollbackFor = [Exception::class])
  fun registerUser(registerData: RegisterRequestDTO) {
    this.validateUserAlreadyExists(registerData.mail.lowercase())

    val initialTerritory  = territoryService.getRandomTerritory()

    this.registerNewUser(registerData, initialTerritory)
  }

  @Transactional(rollbackFor = [Exception::class])
  fun validateUserByToken(token: String) {
    val verifiedToken = verifyToken(token)
    tokenRepository.delete(verifiedToken)
  }
  private fun validateUserAlreadyExists(mail: String) {
    val user = userService.findByMail(mail)
    if (user.isPresent) throw IllegalDataException("El usuario con mail $mail ya existe")
  }

  private fun registerNewUser(registerData: RegisterRequestDTO, initialTerritory: Territory) {
    val user : User = registerData.toUser(initialTerritory).apply { setNewPassword(registerData.rawPassword) }
    val savedUser = userService.save(user)

    val token = tokenRepository.save(Token.createTokenEntity(user))
    val confirmationURL = createConfirmationOrRecoveryLink(token.value)
    eventPublisher.publishEvent(OnRegistrationCompletedEvent(savedUser, confirmationURL))

  }

  private fun verifyToken(token: String): Token {
    if(token.isBlank()) { throw IllegalDataException("Token no puede estar vacío") }
    val verificationToken = this.getVerificationToken(token)
    if(verificationToken.expiryDate.isBefore(LocalDateTime.now())) {
      tokenRepository.delete(verificationToken)
      throw InvalidTokenException()
    }
    return verificationToken
  }


}