package ar.edu.unsam.phm.config

import ar.edu.unsam.phm.utils.exceptions.BusinessException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalEexceptionHandler {

  @ExceptionHandler(Exception::class)
  fun handleBusinessException(ex: BusinessException) : ResponseEntity<String> =
    ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.message)
}