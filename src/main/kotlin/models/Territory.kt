package ar.edu.unsam.phm.models

import ar.edu.unsam.phm.utils.enums.Difficulty
import ar.edu.unsam.phm.utils.enums.TerritoryType
import jakarta.persistence.*


@Entity
class Territory : Locacion() {

  @OneToMany(mappedBy = "parentLocation", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
  var subLocations: MutableList<Locacion> = mutableListOf()

  @Column(nullable = false, columnDefinition = "TEXT")
  lateinit var history: String

  @Column(nullable = false, columnDefinition = "TEXT")
  lateinit var overview: String

  var level: Int = 1

  @Enumerated(EnumType.STRING)
  lateinit var difficulty: Difficulty

  @Enumerated(EnumType.STRING)
  lateinit var type: TerritoryType

  @OneToOne(mappedBy = "territory", cascade = [CascadeType.ALL])
  var info: TerritoryInfo? = null

  @OneToMany(mappedBy = "territory", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
  var resources: MutableList<TerritoryResource> = mutableListOf()

  @OneToMany(mappedBy = "territory", cascade = [CascadeType.ALL], orphanRemoval = true)
  var enemies: MutableList<Enemy> = mutableListOf()

  @Column(name = "pos_left", nullable = false)
  lateinit var left : String

  @Column(name = "pos_top", nullable = false)
  lateinit var top : String

  fun addSubLocation(loc: Locacion) {
    loc.parentLocation = this
    subLocations.add(loc)
  }

  fun describe() : String {
    return """
      ${info?.shortDescription ?: "sin descripcion breve"}
      
      Historia: $history
      
      Descripcion: $overview
      
      Caracteristicas: ${info?.features?.joinToString(", ") ?: "No disponibles"}
      
      Lore: ${info?.lore ?: "No Disponible"}
    """.trimIndent()
  }
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