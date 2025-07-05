package ar.edu.unsam.phm.models

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table


@Entity
@Table(name = "users")
class User: Individual(){

  @Column(unique = true, nullable = false)
  lateinit var mail: String

  @Column(nullable = false, length = 97)
  lateinit var password: String

  fun verifyPassword(password: String): Boolean = this.password == password
}