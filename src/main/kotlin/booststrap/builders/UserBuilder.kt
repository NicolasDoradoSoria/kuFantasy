package ar.edu.unsam.phm.booststrap.builders

import ar.edu.unsam.phm.models.InventorySlot
import ar.edu.unsam.phm.models.Item
import ar.edu.unsam.phm.models.Territory
import ar.edu.unsam.phm.models.User
import ar.edu.unsam.phm.utils.IndividualRole
import ar.edu.unsam.phm.utils.UserType

class UserBuilder {

  companion object {

    fun buildMock(name: String, mail: String = "test@example.com", locacion: Territory, inventoryItems:List<Pair<Item, Int>> = listOf() ) : User {
      return User().apply {
        this.name = name
        this.mail = mail
        this.setNewPassword("password")
        this.defense = 10
        this.life = 100
        this.magic = 20
        this.attack = 30
        this.speed = 15
        this.exp = 100
        this.level = 1
        this.totalCapacity = 100
        this.balance = 100.0
        this.currentLocacion = locacion
        this.role = IndividualRole.COMMON
        this.type = UserType.PLAYER
        this.inventory = inventoryItems.map { InventorySlot.create(it.first, it.second) }.toMutableList()
      }
    }
  }
}