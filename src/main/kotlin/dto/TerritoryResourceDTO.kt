package ar.edu.unsam.phm.dto

import ar.edu.unsam.phm.models.TerritoryResource

data class TerritoryResourceDTO(
  val name: String,
  val rarity: Int
){
  companion object{
    fun from(resource: TerritoryResource): TerritoryResourceDTO =
      TerritoryResourceDTO(
        name = resource.name,
        rarity = resource.rarity
      )
  }
}