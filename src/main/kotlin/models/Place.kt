package ar.edu.unsam.phm.models

abstract class Place : Locacion {
  abstract override  var id: Long
  abstract override var name: String
  abstract override var image: String
  abstract var inventory: List<InventorySlot>

  override fun validate() {
    if (name.isBlank()) throw IllegalArgumentException("Name cannot be blank")
    if (image.isBlank()) throw IllegalArgumentException("Image cannot be blank")
  }
}