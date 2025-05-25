package ar.edu.unsam.phm.models

class House : Locacion {

  override var id: Long = -1
  override lateinit var name: String
  var Individuals: List<Individual> = emptyList()
  var iventory: List<InventorySlot> = emptyList()
  lateinit var image: String
  override fun validate() {
    if (name.isBlank()) {
      throw IllegalArgumentException("Name cannot be blank")
    }
    if (Individuals.isEmpty()) {
      throw IllegalArgumentException("House must have at least one individual")
    }
    if (iventory.isEmpty()) {
      throw IllegalArgumentException("House must have at least one inventory slot")
    }
    if (image.isBlank()) {
      throw IllegalArgumentException("Image cannot be blank")
    }
  }
}