package ar.edu.unsam.phm.booststrap.builders

import ar.edu.unsam.phm.models.InventorySlot
import ar.edu.unsam.phm.models.Item

class InventorySlotBuilder {
    companion object {
        fun buildMock(item: Item, quantity: Int): InventorySlot {
            return InventorySlot().apply {
                this.item = item
                this.quantity = quantity
            }
        }
    }
}