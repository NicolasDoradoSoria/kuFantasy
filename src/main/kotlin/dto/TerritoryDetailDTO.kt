package ar.edu.unsam.phm.dto

import ar.edu.unsam.phm.models.House
import ar.edu.unsam.phm.models.Individual
import ar.edu.unsam.phm.models.Store
import ar.edu.unsam.phm.models.Territory


class TerritoryDetailDTO (
  val id: Long,
  val name: String,
  val imageUrl: String,
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
        resources = territory.resources.map { TerritoryResourceDTO.from(it) },
        enemies = territory.enemies.map { EnemyDTO.from(it) },
        houses = houses.map { HouseDTO.from(it) },
        stores = stores.map { StoreDTO.from(it) },
        npcs = npcs.map { NPCDTO.from(it) }
      )
  }
}