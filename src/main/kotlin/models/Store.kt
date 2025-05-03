package ar.edu.unsam.phm.models

class Store: Locacion {
  override lateinit var name: String
  override var id: Long = -1

  override fun validate() {
    TODO("Not yet implemented")
  }

  lateinit var territory: Territory
  //var employees: List<Merchand> = emptyList()

}