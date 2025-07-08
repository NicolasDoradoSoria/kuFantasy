package ar.edu.unsam.phm.service

import ar.edu.unsam.phm.dao.UserRepository
import ar.edu.unsam.phm.dto.LoginDTO
import ar.edu.unsam.phm.models.User
import ar.edu.unsam.phm.security.JwtTokenUtils
import ar.edu.unsam.phm.utils.exceptions.InvalidCredentialsException
import org.springframework.stereotype.Component

@Component
class LoginService(
  private val userService: UserService,
  private val jwtTokenUtils: JwtTokenUtils
) {
  fun login(loginDTO: LoginDTO) : String {
    val user = this.getUser(loginDTO)
    return jwtTokenUtils.createToken(user.id, user.role.name)!!
  }

  private fun getUser(loginDTO: LoginDTO) : User {
    val user = userService.getByMail(loginDTO.mail)

    if (!user.verifyPassword(loginDTO.password))
      throw InvalidCredentialsException()

    return user
  }
}