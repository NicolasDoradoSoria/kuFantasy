package ar.edu.unsam.phm.models


class Territory : Locacion {
  override var id: Long = -1
  override lateinit var name: String
  var subLocations: List<Locacion> = emptyList()
  lateinit var history: String
  override lateinit var image: String


  override fun validate() {
    if (name.isBlank()) {
      throw IllegalArgumentException("Name cannot be blank")
    }
    if (subLocations.isEmpty()) {
      throw IllegalArgumentException("Territory must have at least one sub-location")
    }
    if (history.isBlank()) {
      throw IllegalArgumentException("History cannot be blank")
    }
    if (image.isBlank()) {
      throw IllegalArgumentException("Image cannot be blank")
    }
  }

  fun stores(): List<Store> = subLocations.filterIsInstance<Store>()
  fun houses(): List<House> = subLocations.filterIsInstance<House>()

}