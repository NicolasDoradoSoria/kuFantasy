package ar.edu.unsam.phm.dto

import ar.edu.unsam.phm.models.Individual

data class IndividualDTO(
  val name: String,
  val defense: Int,
  val life: Int,
  val magic: Int,
  val attack: Int,
  val speed: Int,
  val exp: Int,
  val level: Int,
  val totalCapacity: Int,
  val balance: Double,
  val currentLocacion: String,
  val role: String,
  val type: String,
  val inventory: List<InventorySlotDTO>
) {
  companion object {

    fun toDTO(individual: Individual): IndividualDTO {
      println("Nombre del indiv: ${individual.name}")
      return IndividualDTO(
        name = individual.name,
        defense = individual.defense,
        life = individual.life,
       magic = individual.magic,
        attack = individual.attack,
        speed = individual.speed,
        exp = individual.exp,
        level = individual.level,
        totalCapacity = individual.totalCapacity,
        balance = individual.balance,
        currentLocacion = individual.currentLocacion.name,
        role = individual.role.name,
        type = individual.type.name,
        inventory = individual.inventory.map { InventorySlotDTO.from(it) }
      )
    }
  }
}