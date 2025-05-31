package ar.edu.unsam.phm.models

class Store: Place() {
  lateinit var seller: Individual

  override lateinit var name: String
  override var id: Long = -1
  override lateinit var image: String
  override var inventory: List<InventorySlot> = listOf()

  fun isSellerPresent(someIndividual: Individual) : Boolean = seller == someIndividual

}