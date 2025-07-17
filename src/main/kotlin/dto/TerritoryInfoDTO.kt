package ar.edu.unsam.phm.dto

import ar.edu.unsam.phm.models.TerritoryInfo

data class TerritoryInfoDTO(
  val shortDescription: String,
  val longDescription: String,
  val features: List<String>
){
  companion object {
    fun from(info: TerritoryInfo): TerritoryInfoDTO =
      TerritoryInfoDTO(
        shortDescription = info.shortDescription,
        longDescription = info.longDescription,
        features = info.features.map { it.name }
      )
  }
}