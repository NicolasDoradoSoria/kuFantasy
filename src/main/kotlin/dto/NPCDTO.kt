package ar.edu.unsam.phm.dto

import ar.edu.unsam.phm.models.Individual
import ar.edu.unsam.phm.utils.IndividualRole

data class NPCDTO (
  val id: Long,
  val name: String,
  val role: IndividualRole,
  val imageUrl: String
){
  companion object {
    fun from(npc: Individual) : NPCDTO {
      return NPCDTO(
        id  =npc.id,
        name = npc.name,
        role = npc.role,
        imageUrl = npc.imageUrl
      )
    }
  }
}