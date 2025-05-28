package ar.edu.unsam.phm.models

class Store: Place() {
  lateinit var seller: Individual

  override lateinit var name: String
  override var id: Long = -1
  override lateinit var image: String
  override var inventory: List<InventorySlot> = listOf()

  override fun validate() {
    super.validate()

  }

  fun isSellerPresent(someIndividual: Individual) : Boolean = seller == someIndividual

}