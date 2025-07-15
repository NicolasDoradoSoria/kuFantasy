package ar.edu.unsam.phm.dto

import ar.edu.unsam.phm.models.User

data class UserInfoDTO(
  val id: Long,
  val name: String,
  val mail: String,
  val hasCharacter: Boolean
){
  companion object {
    fun from(user: User) = UserInfoDTO(
      id = user.id,
      name = user.name,
      mail = user.mail,
      hasCharacter = userHasCharacter(user)
    )

    private fun userHasCharacter(user: User) : Boolean = user.characterCreated
  }
}