package ar.edu.unsam.phm.utils.exceptions

data class InvalidTokenException(override val message: String = "Token inválido") : Exception(message)