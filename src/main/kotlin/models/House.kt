package ar.edu.unsam.phm.models

class House : Identifier, Locacion {

  override var id: Long = -1
  override lateinit var name: String
  var Individuals: List<Individual> = emptyList()
  var Items: List<Item> = emptyList()
  lateinit var image: String
  override fun validate() {
    TODO("Not yet implemented")
  }
}