package ar.edu.unsam.phm.models

class House : Locacion {

  override var id: Long = -1
  override lateinit var name: String
  var Individuals: List<Individual> = emptyList()
  var iventory: List<InventorySlot> = emptyList()
  lateinit var image: String
  override fun validate() {
    TODO("Not yet implemented")
  }
}