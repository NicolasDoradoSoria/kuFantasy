package ar.edu.unsam.phm.models

import ar.edu.unsam.phm.utils.enums.StoreType
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne


@Entity
class Store: Place() {

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "seller_id", nullable = false)
  lateinit var seller: Individual

  var type: StoreType = StoreType.GENERAL_STORE
  fun isSellerPresent(someIndividual: Individual) : Boolean = seller == someIndividual

}