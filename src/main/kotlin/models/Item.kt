package ar.edu.unsam.phm.models

class Item : Identifier{
  override var id: Long = -1
  lateinit var name: String
  lateinit var description: String
  var weight: Int = 0
  var price: Double = 0.0
  var defense : Int = 0
  var life : Int = 0
  var magic : Int = 0
  var attack : Int = 0
  var speed : Int = 0
  lateinit var image: String

  override fun validate() {
    if (name.isBlank()) {
      throw IllegalArgumentException("Name cannot be blank")
    }
    if (description.isBlank()) {
      throw IllegalArgumentException("Description cannot be blank")
    }
    if (weight < 0) {
      throw IllegalArgumentException("Weight cannot be negative")
    }
    if (price < 0) {
      throw IllegalArgumentException("Price cannot be negative")
    }
    if (defense < 0 || life < 0 || magic < 0 || attack < 0 || speed < 0) {
      throw IllegalArgumentException("Attributes cannot be negative")
    }
    if (!::image.isInitialized) {
      throw IllegalArgumentException("Image must be initialized")
    }
  }
}