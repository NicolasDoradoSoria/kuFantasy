package ar.edu.unsam.phm.booststrap.builders

import ar.edu.unsam.phm.models.*

class HouseBuilder {
  companion object {
    fun buildMock(name: String, image: String, residents: List<User> = listOf(),  inventoryItems: List<Pair<Item, Int>> = listOf(),  parent: Locacion): House {
      return House().apply {
        this.name = name
        this.image = image
        this.residents = residents.toMutableList()
        this.inventory = inventoryItems.map { InventorySlot.create(it.first, it.second) }.toMutableList()
        this.parentLocation = parent
      }
    }
  }
}