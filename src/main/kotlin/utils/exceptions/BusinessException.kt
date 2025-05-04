package ar.edu.unsam.phm.utils.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.BAD_REQUEST)
data class BusinessException(val msg : String= "error") : Exception(msg)