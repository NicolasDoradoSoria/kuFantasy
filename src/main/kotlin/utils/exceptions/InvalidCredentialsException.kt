package ar.edu.unsam.phm.utils.exceptions

data class InvalidCredentialsException (override val message : String = "Credenciales inválidas") : Exception(message)