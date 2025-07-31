package ar.edu.unsam.phm.booststrap.builders

import ar.edu.unsam.phm.models.*
import ar.edu.unsam.phm.utils.enums.StoreType

class StoreBuilder {
  companion object {
    fun buildMock(name: String, seller: Individual, image: String, inventoryItems: List<Pair<Item, Int>> = listOf(), parent: Locacion, type: StoreType = StoreType.GENERAL_STORE ): Store {
      return Store().apply {
        this.name = name
        this.image = image
        this.seller = seller
        this.inventory = inventoryItems.map { InventorySlot.create(it.first, it.second) }.toMutableList()
        this.parentLocation = parent
        this.type = type
      }
    }
  }
}