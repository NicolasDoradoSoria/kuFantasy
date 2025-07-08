package ar.edu.unsam.phm.booststrap.builders

import ar.edu.unsam.phm.models.Individual
import ar.edu.unsam.phm.models.InventorySlot
import ar.edu.unsam.phm.models.Item
import ar.edu.unsam.phm.models.Territory
import ar.edu.unsam.phm.utils.IndividualRole
import ar.edu.unsam.phm.utils.UserType

class IndividualBuilder {
  companion object {
    fun buildMock (
      name: String = "NPC", role: IndividualRole = IndividualRole.MERCHANT, locacion: Territory,
      inventorySlots: List<InventorySlot> = listOf(), balance: Double = 100.0) : Individual {
      val individual = Individual().apply {
        this.name = name
        this.lastName = "NPC"
        this.defense = 5
        this.life = 50
        this.magic = 5
        this.attack = 10
        this.speed = 5
        this.exp = 50
        this.level = 1
        this.totalCapacity = 80
        this.balance = balance
        this.currentLocacion = locacion
        this.role = role
        this.type = UserType.NPC
        this.inventory = inventorySlots.toMutableList()
      }

      return individual
    }
  }
}