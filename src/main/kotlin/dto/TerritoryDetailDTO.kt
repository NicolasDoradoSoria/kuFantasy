package ar.edu.unsam.phm.dto

import ar.edu.unsam.phm.models.House
import ar.edu.unsam.phm.models.Individual
import ar.edu.unsam.phm.models.Store
import ar.edu.unsam.phm.models.Territory
import ar.edu.unsam.phm.utils.enums.Difficulty
import ar.edu.unsam.phm.utils.enums.TerritoryType

class TerritoryDetailDTO (
  val id: Long,
  val name: String,
  val imageUrl: String,
  val overview: String,
  val history: String,
  val level: Int,
  val difficulty: Difficulty,
  val type: TerritoryType,
  val info: TerritoryInfoDTO?,
  val resources: List<TerritoryResourceDTO>,
  val enemies: List<EnemyDTO>,
  val houses: List<HouseDTO>,
  val stores: List<StoreDTO>,
  val npcs: List<NPCDTO>
){
  companion object {
    fun from (territory: Territory, houses: List<House>, stores: List<Store>, npcs: List<Individual>): TerritoryDetailDTO =
      TerritoryDetailDTO(
        id= territory.id,
        name = territory.name,
        imageUrl= territory.image,
        overview = territory.overview,
        history = territory.history,
        level = territory.level,
        difficulty = territory.difficulty,
        type = territory.type,
        info = territory.info?.let { TerritoryInfoDTO.from(it) },
        resources = territory.resources.map { TerritoryResourceDTO.from(it) },
        enemies = territory.enemies.map { EnemyDTO.from(it) },
        houses = houses.map { HouseDTO.from(it) },
        stores = stores.map { StoreDTO.from(it) },
        npcs = npcs.map { NPCDTO.from(it) }
      )
  }
}