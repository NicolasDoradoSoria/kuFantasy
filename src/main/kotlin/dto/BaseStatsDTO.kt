package ar.edu.unsam.phm.dto

import ar.edu.unsam.phm.models.Combatant

data class BaseStatsDTO(
  val attack: Int,
  val defense: Int,
  val speed: Int,
  val life: Int,
  val magic: Int,
  val level: Int
){
  companion object {
    fun from(combatant: Combatant) = BaseStatsDTO(
      attack = combatant.attack,
      defense = combatant.defense,
      speed = combatant.speed,
      life = combatant.life,
      magic = combatant.magic,
      level = combatant.level
    )
  }
}