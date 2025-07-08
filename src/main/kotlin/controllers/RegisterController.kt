package ar.edu.unsam.phm.controllers

import ar.edu.unsam.phm.dto.RegisterRequestDTO
import ar.edu.unsam.phm.service.RegisterService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/registration")
class RegisterController(
  private val registerService: RegisterService
) {
  @PostMapping("/")
  fun registerUser(@RequestBody registerData: RegisterRequestDTO) {
    registerService.registerUser(registerData)
  }

  @GetMapping("/confirm")
  fun confirmRegistration(@RequestParam token: String) {
    registerService.validateUserByToken(token)
  }
}