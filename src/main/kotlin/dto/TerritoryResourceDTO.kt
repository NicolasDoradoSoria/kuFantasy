package ar.edu.unsam.phm.dto

import ar.edu.unsam.phm.models.TerritoryResource

data class TerritoryResourceDTO(
  val id: Long,
  val name: String,
  val rarity: Int
){
  companion object{
    fun from(resource: TerritoryResource): TerritoryResourceDTO =
      TerritoryResourceDTO(
        id = resource.id,
        name = resource.name,
        rarity = resource.rarity
      )
  }
}