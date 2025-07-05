package ar.edu.unsam.phm.booststrap.builders

import ar.edu.unsam.phm.models.House
import ar.edu.unsam.phm.models.InventorySlot
import ar.edu.unsam.phm.models.Item
import ar.edu.unsam.phm.models.User

class HouseBuilder {
  companion object {
    fun buildMock(name: String, image: String, residents: List<User> = listOf(),  inventoryItems: List<Pair<Item, Int>> = listOf()): House {
      return House().apply {
        this.name = name
        this.image = image
        this.residents = residents.toMutableList()
        this.inventory = inventoryItems.map { InventorySlot.create(it.first, it.second) }.toMutableList()
      }
    }
  }
}