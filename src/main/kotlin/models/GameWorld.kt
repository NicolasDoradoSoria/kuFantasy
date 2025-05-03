package ar.edu.unsam.phm.models

class GameWorld : Identifier {
  override var id: Long = -1
  lateinit var name: String
  var individuals: List<Individual> = emptyList()
  var territories: List<Territory> = emptyList()
  lateinit var history: String
  lateinit var image: String
  override fun validate() {
    require(name.isNotBlank()) { "GameWorld debe tener un nombre" }
    require(territories.isNotEmpty()) { "Al menos un territorio es necesario" }
  }

}