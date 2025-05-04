package ar.edu.unsam.phm.models

class Transaction {
  lateinit var item: Item
  var quantity: Int = 0
  var unitPrice: Double = 0.0
  var totalPrice: Double = 0.0
  //lateinit var data: DataTime
  lateinit var individual: Individual
  lateinit var store: Store

}