package ar.edu.unsam.phm.config

import ar.edu.unsam.phm.utils.exceptions.*
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalEexceptionHandler {

  @ExceptionHandler(IllegalDataException::class)
  fun handleIllegalData(e: IllegalDataException): ResponseEntity<SimpleResponse> {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(SimpleResponse(e.message))
  }

  @ExceptionHandler(NotFoundException::class)
  fun handleNotFound(e: NotFoundException): ResponseEntity<SimpleResponse> {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(SimpleResponse(e.message))
  }

  @ExceptionHandler(InvalidCredentialsException::class)
  fun handleInvalidCredentials(e: InvalidCredentialsException): ResponseEntity<SimpleResponse> {
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(SimpleResponse(e.message))
  }

  @ExceptionHandler(InvalidTokenException::class)
  fun handleInvalidTokenException(e: InvalidTokenException): ResponseEntity<SimpleResponse> {
    return ResponseEntity.status((HttpStatus.UNAUTHORIZED)).body(SimpleResponse(e.message))
  }
}