package ar.edu.unsam.phm.dto

import ar.edu.unsam.phm.models.Locacion
import ar.edu.unsam.phm.models.Store
import ar.edu.unsam.phm.utils.enums.StoreType


data class StoreDTO(
    val id: Long,
    val name: String,
    val image: String,
    val inventory: List<InventorySlotDTO>,
    val type: StoreType
) {
    companion object {
        fun from(store: Store): StoreDTO {
            return StoreDTO(
                id = store.id,
                name = store.name,
                image = store.image,
                inventory = store.inventory.map { InventorySlotDTO.from(it) },
                type = store.type
            )
        }
    }
}