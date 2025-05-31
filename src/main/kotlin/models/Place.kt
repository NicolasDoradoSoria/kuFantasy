package ar.edu.unsam.phm.models

abstract class Place : Locacion {
  abstract override  var id: Long
  abstract override var name: String
  abstract override var image: String
  abstract var inventory: List<InventorySlot>

  override fun validate() {
    if (name.isBlank()) throw IllegalArgumentException("Name cannot be blank")
    if (image.isBlank()) throw IllegalArgumentException("Image cannot be blank")
  }

  fun removeItemById(itemId: Long): InventorySlot {
    val slot = this.getItemById(itemId)
    inventory = inventory.toMutableList().apply { remove(slot) }
    return slot
  }

  fun removeItem(item: Item) : InventorySlot = removeItemById(item.id)

  fun getItemById(itemId: Long): InventorySlot = inventory.find { it.item.id == itemId } ?: throw IllegalArgumentException("Item with id $itemId not found in inventory")

}