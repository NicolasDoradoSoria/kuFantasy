package ar.edu.unsam.phm.models

import jakarta.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
abstract class Place : Locacion() {

  @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
  open var inventory: MutableList<InventorySlot> = mutableListOf()

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