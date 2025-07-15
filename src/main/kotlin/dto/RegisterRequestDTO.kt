package ar.edu.unsam.phm.dto

import ar.edu.unsam.phm.models.Territory
import ar.edu.unsam.phm.models.User
import ar.edu.unsam.phm.utils.IndividualRole
import ar.edu.unsam.phm.utils.functions.datifyStringWithDay

class RegisterRequestDTO(
    val mail: String,
    val rawPassword: String,
    val name: String,
    val lastName: String
)

fun RegisterRequestDTO.toUser(defaultTerritory: Territory): User {
  val request: RegisterRequestDTO = this

    return User().apply {
      mail = this@toUser.mail.trim().lowercase()
      name = this@toUser.name.trim()
      lastName = this@toUser.lastName.trim()
      currentLocacion = defaultTerritory
      role = IndividualRole.COMMON
      setNewPassword(rawPassword.trim())
      validate()
    }
}