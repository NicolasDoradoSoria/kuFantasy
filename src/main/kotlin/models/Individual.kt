package ar.edu.unsam.phm.models

import ar.edu.unsam.phm.utils.IndividualRole

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
  lateinit var currentLocacion: Locacion
  lateinit var role: IndividualRole
  var inventory: List<InventorySlot> = emptyList()

  override fun validate() {
    TODO("Not yet implemented")
  }
}