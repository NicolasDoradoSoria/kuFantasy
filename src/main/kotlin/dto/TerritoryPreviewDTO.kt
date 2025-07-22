package ar.edu.unsam.phm.dto

import ar.edu.unsam.phm.models.Territory
import ar.edu.unsam.phm.utils.enums.Difficulty
import ar.edu.unsam.phm.utils.enums.TerritoryType

data class TerritoryPreviewDTO(
  val id: Long,
  val name: String,
  val overview: String,
  val history: String,
  val level: Int,
  val difficulty: Difficulty,
  val type: TerritoryType,
  val info: TerritoryInfoDTO?,
  val resources: List<TerritoryResourceDTO>,
  val enemies: List<EnemyDTO>
){
  companion object {
    fun from (territory: Territory): TerritoryPreviewDTO =
      TerritoryPreviewDTO(
        id= territory.id,
        name = territory.name,
        overview = territory.overview,
        history = territory.history,
        level = territory.level,
        difficulty = territory.difficulty,
        type = territory.type,
        info = territory.info?.let { TerritoryInfoDTO.from(it) },
        resources = territory.resources.map { TerritoryResourceDTO.from(it) },
        enemies = territory.enemies.map { EnemyDTO.from(it) }
      )
  }
}