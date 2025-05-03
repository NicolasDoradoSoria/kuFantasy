package ar.edu.unsam.phm.models


class Territory : Locacion {
  override var id: Long = -1
  override lateinit var name: String
  var subLocations: List<Locacion> = emptyList()
  lateinit var history: String
  lateinit var image: String


  override fun validate() {
    TODO("Not yet implemented")
  }
}