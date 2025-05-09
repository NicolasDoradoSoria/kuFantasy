package ar.edu.unsam.phm.models

class User: Individual(){
  lateinit var mail: String
  lateinit var password: String

  fun verifyPassword(password: String): Boolean = this.password == password
}