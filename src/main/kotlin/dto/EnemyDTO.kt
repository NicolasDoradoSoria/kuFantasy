package ar.edu.unsam.phm.dto

import ar.edu.unsam.phm.models.Enemy


data class EnemyDTO(
  val id: Long,
  val name: String,
  val level: Int
){
  companion object{
    fun from(enemy: Enemy): EnemyDTO =
      EnemyDTO(
        id = enemy.id,
        name = enemy.name,
        level = enemy.level
      )
  }
}