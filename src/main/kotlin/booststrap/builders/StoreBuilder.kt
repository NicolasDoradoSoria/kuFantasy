package ar.edu.unsam.phm.booststrap.builders

import ar.edu.unsam.phm.models.*

class StoreBuilder {
  companion object {
    fun buildMock(name: String, seller: Individual, image: String, inventoryItems: List<Pair<Item, Int>> = listOf(), parent: Locacion): Store {
      return Store().apply {
        this.name = name
        this.image = image
        this.seller = seller
        this.inventory = inventoryItems.map { InventorySlot.create(it.first, it.second) }.toMutableList()
        this.parentLocation = parent
      }
    }
  }
}