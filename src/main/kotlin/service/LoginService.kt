package ar.edu.unsam.phm.service

import ar.edu.unsam.phm.dao.UserRepository
import ar.edu.unsam.phm.dto.LoginDTO
import ar.edu.unsam.phm.utils.exceptions.InvalidCredentialsException
import org.springframework.stereotype.Component

@Component
class LoginService(
  val userRepository: UserRepository
) {
  fun validUser(mail: String) = userRepository.findByMail(mail)   ?: throw InvalidCredentialsException()
  fun login(loginDTO: LoginDTO) {
    val user = this.validUser(loginDTO.mail)
    if(user== null || !user.verifyPassword(loginDTO.password)) {
      throw InvalidCredentialsException()
    }
  }

}