package ar.edu.unsam.phm.service

import ar.edu.unsam.phm.dao.UserRepository
import ar.edu.unsam.phm.dto.UserInfoDTO
import ar.edu.unsam.phm.models.User
import ar.edu.unsam.phm.utils.exceptions.NotFoundException
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(
  private val userRepository: UserRepository,
) {
  fun getById(userId: Long): User = userRepository.findById(userId).orElseThrow{throw Exception("Usuario no encontrado con ID: $userId")}


  fun getByMail(mail: String): User =
    userRepository.findByMail(mail).orElseThrow { NotFoundException("Usuario no encontrado $mail")}

  fun findByMail(mail : String) : Optional<User> =
    userRepository.findByMail(mail)

  fun save(user : User) = userRepository.save(user)

  fun getCurrentUser(currentUserId: Long): UserInfoDTO {
    val user = this.getById(currentUserId)

    return UserInfoDTO.from(user)
  }

}