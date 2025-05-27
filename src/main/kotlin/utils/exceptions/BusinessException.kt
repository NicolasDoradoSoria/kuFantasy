package ar.edu.unsam.phm.utils.exceptions


data class BusinessException(val msg : String= "error") : Exception(msg)