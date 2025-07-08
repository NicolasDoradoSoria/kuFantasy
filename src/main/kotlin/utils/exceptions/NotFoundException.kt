package ar.edu.unsam.phm.utils.exceptions

data class NotFoundException(override val message: String = "Ha habido un error al recuperar los datos") : Exception(message)