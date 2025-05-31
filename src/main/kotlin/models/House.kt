package ar.edu.unsam.phm.models

class House : Place() {
  var residents: List<Individual> = emptyList()

  override var id: Long = -1
  override lateinit var name: String
  override lateinit var image: String
  override var inventory: List<InventorySlot> = listOf()


}