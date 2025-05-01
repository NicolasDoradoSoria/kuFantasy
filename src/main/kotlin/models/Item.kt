package ar.edu.unsam.phm.models

class Item : Identifier{
  override var id: Long = -1
  lateinit var name: String
  lateinit var description: String
  var weight: Int = 0
  var price: Double = 0.0
  var defense : Int = 0
  var life : Int = 0
  var magic : Int = 0
  var attack : Int = 0
  var speed : Int = 0
  lateinit var image: String

  override fun validate() {
    TODO("Not yet implemented")
  }
}