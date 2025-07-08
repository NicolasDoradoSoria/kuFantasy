package ar.edu.unsam.phm.utils.exceptions

data class IllegalDataException (override val message : String) : Exception(message)