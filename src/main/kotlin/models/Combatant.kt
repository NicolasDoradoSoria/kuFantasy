package ar.edu.unsam.phm.models

import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass

@MappedSuperclass
open class Combatant : Identifier {

  @Id
  @GeneratedValue
  override var id: Long = 0
  override fun validate() {
    TODO("Not yet implemented")
  }

  lateinit var name: String
  open var attack: Int = 0
  open var defense: Int = 0
  open var speed: Int = 0
  open var level: Int = 0
  open var life: Int = 0
  open var magic: Int = 0
}