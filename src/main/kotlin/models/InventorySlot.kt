package ar.edu.unsam.phm.models

class InventorySlot {
  lateinit var item: Item
  var quantity: Int = 1

  companion object {
    fun create(item: Item, quantity: Int = 1): InventorySlot {
      val slot = InventorySlot()
      slot.item = item
      slot.quantity = quantity
      return slot
    }
  }
}