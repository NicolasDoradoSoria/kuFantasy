package ar.edu.unsam.phm.controllers

import ar.edu.unsam.phm.dto.LoginDTO
import ar.edu.unsam.phm.service.LoginService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/login")
@CrossOrigin("*")

class LoginController (val loginService: LoginService) {
    @PostMapping("/")
    fun loginCustomer(@RequestBody loginDTO: LoginDTO) =
        loginService.login(loginDTO)

}