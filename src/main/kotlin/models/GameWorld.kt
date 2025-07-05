package ar.edu.unsam.phm.models

import jakarta.persistence.*

@Entity
class GameWorld : Identifier {

  @Id
  @GeneratedValue
  override var id: Long = 0

  @Column(nullable = false, unique = true)
  lateinit var name: String

  @OneToMany(cascade = [CascadeType.ALL])
  @JoinColumn(name = "game_world_id")
  var individuals: MutableList<Individual> = mutableListOf()

  @OneToMany(cascade = [CascadeType.ALL])
  @JoinColumn(name = "game_world_id")
  var territories: MutableList<Territory> = mutableListOf()

  @Column(nullable = false, columnDefinition = "TEXT")
  lateinit var history: String

  @Column(nullable = false)
  lateinit var image: String
  override fun validate() {
    require(name.isNotBlank()) { "GameWorld debe tener un nombre" }
    require(territories.isNotEmpty()) { "Al menos un territorio es necesario" }
  }


}