package ar.edu.unsam.phm.models


class Territory : Identifier, Locacion {
  override var id: Long = -1
  override lateinit var name: String
  val subLocations: List<Locacion> = emptyList()
  lateinit var history: String
  lateinit var image: String

  override fun validate() {
    TODO("Not yet implemented")
  }
}