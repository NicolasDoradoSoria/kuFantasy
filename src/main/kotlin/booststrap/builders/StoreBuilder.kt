package ar.edu.unsam.phm.booststrap.builders

import ar.edu.unsam.phm.models.Individual
import ar.edu.unsam.phm.models.InventorySlot
import ar.edu.unsam.phm.models.Item
import ar.edu.unsam.phm.models.Store

class StoreBuilder {
  companion object {
    fun buildMock(name: String, seller: Individual, image: String, inventoryItems: List<Pair<Item, Int>> = listOf()): Store {
      return Store().apply {
        this.name = name
        this.image = image
        this.seller = seller
        this.inventory = inventoryItems.map { InventorySlot.create(it.first, it.second) }.toMutableList()
      }
    }
  }
}