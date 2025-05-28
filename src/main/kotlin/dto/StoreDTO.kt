package ar.edu.unsam.phm.dto

import ar.edu.unsam.phm.models.Locacion


data class StoreDTO(
    val id: Long,
    val name: String,
    val image: String
) {
    companion object {
        fun from(store: Locacion): StoreDTO {
            return StoreDTO(
                id = store.id,
                name = store.name,
                image = store.image
            )
        }
    }
}