package ar.edu.unsam.phm.models

import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass

@MappedSuperclass
abstract class Combatant : Identifier {

  @Id
  @GeneratedValue
  override var id: Long = 0

  lateinit var name: String
  var attack: Int = 0
  var defense: Int = 0
  var speed: Int = 0
  var level: Int = 0
  var life: Int = 0
  var magic: Int = 0
}