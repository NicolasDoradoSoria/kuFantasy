package ar.edu.unsam.phm.dto

import ar.edu.unsam.phm.models.Territory

data class TerritoryDTO(
    val id: Long,
    val name: String,
    val image: String,
    val stores: List<StoreDTO>,
    val houses : List<HouseDTO>

) {
    companion object {
        fun from(territory: Territory): TerritoryDTO =
            TerritoryDTO(
                id = territory.id,
                name = territory.name,
                image = territory.image,
                stores = territory.stores().map { StoreDTO.from(it) },
                houses = territory.houses().map { HouseDTO.from(it) }
            )
    }
}