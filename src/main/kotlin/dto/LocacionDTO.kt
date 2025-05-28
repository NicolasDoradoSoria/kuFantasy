package ar.edu.unsam.phm.dto

import ar.edu.unsam.phm.models.House
import ar.edu.unsam.phm.models.Locacion
import ar.edu.unsam.phm.models.Store

data class LocacionDTO(
  val name: String,
  val image: String,
  val type: String
){
  companion object {
    fun from(locacion: Locacion): LocacionDTO =
      LocacionDTO(
        name = locacion.name,
        image = locacion.image,
        type = when (locacion) {
          is Store -> "STORE"
          is House -> "HOUSE"
          else -> "UNKNOWN"
        }
      )
  }
}