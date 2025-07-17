package ar.edu.unsam.phm.models

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne

@Entity
class Enemy: Combatant(), Identifier {

  @Id
  @GeneratedValue
  override var id: Long = 0

  lateinit var type: String

  var expReward: Int = 0

  var loot: String? = null

  @ManyToOne
  lateinit var territory: Territory

  fun isDead(): Boolean = life <= 0

  override fun validate() {
    TODO("Not yet implemented")
  }


}