package ar.edu.unsam.phm.models

import ar.edu.unsam.phm.utils.IndividualRole
import ar.edu.unsam.phm.utils.UserType
import ar.edu.unsam.phm.utils.exceptions.BusinessException

open class Individual : Identifier {

  override var id: Long = -1
  lateinit var name: String
  var defense: Int = 0
  var life: Int = 0
  var magic: Int = 0
  var attack: Int = 0
  var speed: Int = 0
  var exp: Int = 0
  var level: Int = 1
  var totalCapacity: Int = 0
  var balance: Double = 0.0
  lateinit var currentLocacion: Territory
  lateinit var role: IndividualRole
  var type: UserType = UserType.PLAYER
  var inventory: MutableList<InventorySlot> = mutableListOf()

  override fun validate() {
    if (name.isBlank()) {
      throw IllegalArgumentException("Name cannot be blank")
    }
    if (defense < 0 || life < 0 || magic < 0 || attack < 0 || speed < 0) {
      throw IllegalArgumentException("Attributes cannot be negative")
    }
    if (exp < 0 || level < 1 || totalCapacity < 0 || balance < 0) {
      throw IllegalArgumentException("Experience, level, total capacity, and balance must be non-negative")
    }
    if (!::currentLocacion.isInitialized) {
      throw IllegalArgumentException("Current location must be initialized")
    }
    if (!::role.isInitialized) {
      throw IllegalArgumentException("Role must be initialized")
    }
  }

  fun addItem(item: Item, quantity: Int = 1) {
    val existing = inventory.find { it.item.id == item.id }
    if (existing != null) {
      existing.quantity += quantity
    } else
      inventory = inventory.toMutableList().apply { add(InventorySlot.create(item, quantity)) }
  }

  fun buyItemFrom(seller: Individual, itemId: Long){
    if (seller.role != IndividualRole.MERCHANT)
      throw BusinessException("Solo se puede comprar a individuos con rol MERCHANT.")

    if(this.currentLocacion != seller.currentLocacion)
      throw BusinessException("No estás en la misma locación que el vendedor para comprar este ítem.")

    val itemSlot = seller.inventory.find { it.item.id == itemId }
      ?: throw BusinessException("El vendedor no tiene el ítem con id ${itemId} en su inventario.")

    val item = itemSlot.item
    val price = item.price

    if(this.balance < price)
      throw BusinessException("No tenés suficiente dinero para comprar el ítem con id ${itemId}.")

    if(itemSlot.quantity == 1)
      seller.inventory.remove(itemSlot)
    else
      itemSlot.quantity -= 1

    this.addItem(item)
    this.balance -= price
    seller.balance += price
  }
}