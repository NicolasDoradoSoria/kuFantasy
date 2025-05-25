package ar.edu.unsam.phm.models

import ar.edu.unsam.phm.utils.IndividualRole
import ar.edu.unsam.phm.utils.UserType

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
  var inventory: List<InventorySlot> = emptyList()

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
}