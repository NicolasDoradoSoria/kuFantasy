package ar.edu.unsam.phm.models

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import java.time.LocalDate


@Entity
@Table(name = "users")
class User: Individual(){

  @Column(unique = true, nullable = false)
  lateinit var mail: String

  @Column(nullable = false, length = 97)
  lateinit var password: String


  @Column
  var dateBirth: LocalDate? = null

  fun verifyPassword(password: String): Boolean = getDefaultPasswordEncoder().matches(password, this.password)

  private fun getDefaultPasswordEncoder(): PasswordEncoder = Argon2PasswordEncoder.defaultsForSpringSecurity_v5_8()!!

  private fun validateNewPassword(newPassword: String) {
      val validPassword = newPassword.trim().length >= 6 && !(newPassword.trim().contains(" "))
      if (!validPassword) {
        throw IllegalArgumentException("La contraseña debe tener al menos 6 caracteres y no contener espacios.")
      }
    }
  fun setNewPassword(newPassword: String) {
    this.validateNewPassword(newPassword)
    password = getDefaultPasswordEncoder().encode(newPassword)
  }
}