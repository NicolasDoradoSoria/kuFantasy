package ar.edu.unsam.phm.dto

import ar.edu.unsam.phm.models.House

data class HouseDTO(
    val id: Long,
    val name: String,
    val image: String
) {
    companion object {
        fun from(house: House): HouseDTO {
            return HouseDTO(
                id = house.id,
                name = house.name,
                image = house.image
            )
        }
    }
}
