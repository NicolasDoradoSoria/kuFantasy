package ar.edu.unsam.phm.models

class PickUpItemCommand (
  val individual: Individual,
  val item: Item,
  private val place: Place
){
  fun execute() {
    place.removeItem(item)
    individual.addItem(item)
  }
}