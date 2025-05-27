package ar.edu.unsam.phm.dto

import ar.edu.unsam.phm.models.InventorySlot

class InventorySlotDTO (
  val name: String,
  val quantity: Int
){
  companion object {
    fun from(inventorySlot: InventorySlot): InventorySlotDTO {
      println("Item en slot: ${inventorySlot.item.name}")
      return InventorySlotDTO(
        name = inventorySlot.item.name,
        quantity = inventorySlot.quantity
      )
    }
  }
}