package ar.edu.unsam.phm.models

import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
open class Race :Combatant(), Identifier {
  @Id
  @GeneratedValue
  override var id: Long = 0

  lateinit var description : String
  lateinit var imageUrl: String

  @Embedded
  lateinit var colorTheme: ColorTheme
  override fun validate() {
    TODO("Not yet implemented")
  }
}