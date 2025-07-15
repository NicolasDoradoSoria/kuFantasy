package ar.edu.unsam.phm.controllers

import ar.edu.unsam.phm.service.UserService
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(
  val userService: UserService
) {
  @ModelAttribute("currentUserId")
  fun getCurrentUserId(): Long {
    val usernamePAT = SecurityContextHolder.getContext().authentication
    return usernamePAT.principal.toString().toLong()
  }
  @GetMapping("/me")
  fun getCurrentUser(@ModelAttribute("currentUserId") currentUserId: Long) = userService.getCurrentUser(currentUserId)
}