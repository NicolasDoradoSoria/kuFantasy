package ar.edu.unsam.phm.models

import jakarta.persistence.*


@Entity
class Territory : Locacion() {

  @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
  @JoinColumn(name = "territory_id")
  var subLocations: MutableList<Locacion> = mutableListOf()

  @Column(nullable = false, columnDefinition = "TEXT")
  lateinit var history: String


  override fun validate() {
    if (name.isBlank()) {
      throw IllegalArgumentException("Name cannot be blank")
    }
    if (subLocations.isEmpty()) {
      throw IllegalArgumentException("Territory must have at least one sub-location")
    }
    if (history.isBlank()) {
      throw IllegalArgumentException("History cannot be blank")
    }
    if (image.isBlank()) {
      throw IllegalArgumentException("Image cannot be blank")
    }
  }

  fun stores(): List<Store> = subLocations.filterIsInstance<Store>()
  fun houses(): List<House> = subLocations.filterIsInstance<House>()

}