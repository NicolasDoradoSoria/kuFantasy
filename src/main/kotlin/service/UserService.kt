package ar.edu.unsam.phm.service

import ar.edu.unsam.phm.dao.UserRepository
import ar.edu.unsam.phm.models.User
import ar.edu.unsam.phm.utils.exceptions.NotFoundException
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(
  private val userRepository: UserRepository,
) {

  fun getByMail(mail: String): User =
    userRepository.findByMail(mail).orElseThrow { NotFoundException("Usuario no encontrado $mail")}

  fun findByMail(mail : String) : Optional<User> =
    userRepository.findByMail(mail)

  fun save(user : User) = userRepository.save(user)

}