package ar.edu.unsam.phm.models

class Store: Locacion {
  override lateinit var name: String
  override var id: Long = -1
  lateinit var territory: Territory

  override fun validate() {
    if (name.isEmpty()) {
      throw IllegalArgumentException("El nombre de la tienda no puede estar vacío")
    }
    if (territory.id == -1L) {
      throw IllegalArgumentException("La tienda debe pertenecer a un territorio")
    }
  }


}