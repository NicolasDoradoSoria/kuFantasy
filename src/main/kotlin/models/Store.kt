package ar.edu.unsam.phm.models

class Store: Locacion {
  override lateinit var name: String
  override var id: Long = -1
  lateinit var territory: Territory

  override fun validate() {
    TODO("Not yet implemented")
  }


}