package ar.edu.unsam.phm.models

import jakarta.persistence.*


@Entity
class TerritoryResource : Identifier {
  @Id @GeneratedValue
  override var id: Long = 0
  override fun validate() {
    TODO("Not yet implemented")
  }

  @Column(nullable = false)
  lateinit var name: String  // Ej: "Iron Ore", "Magic Herb", "Wood"

  @Column(nullable = false)
  var rarity: Int = 1

  @ManyToOne
  @JoinColumn(name = "territory_id")
  lateinit var territory: Territory
}