package ar.edu.unsam.phm.models

import ar.edu.unsam.phm.utils.enums.TerritoryFeature
import jakarta.persistence.*

@Entity
class TerritoryInfo : Identifier {

  @Id
  @GeneratedValue
  override var id: Long = 0
  override fun validate() {
    if (shortDescription.isBlank() || longDescription.isBlank()) {
      throw IllegalArgumentException("Descriptions must not be blank")
    }
    if (lore.isBlank()) {
      throw IllegalArgumentException("Lore is required")
    }
  }

  @Column(nullable = false, columnDefinition = "TEXT")
  lateinit var shortDescription: String

  @Column(nullable = false, columnDefinition = "TEXT")
  lateinit var longDescription: String

  @ElementCollection(targetClass = TerritoryFeature::class)
  @Enumerated(EnumType.STRING)
  var features: List<TerritoryFeature> = listOf()

  @Column(nullable = false, columnDefinition = "TEXT")
  lateinit var lore: String

  @OneToOne
  @JoinColumn(name = "territory_id")
  lateinit var territory: Territory


}