package ar.edu.unsam.phm.controllers

import ar.edu.unsam.phm.dto.BuyItemDTO
import ar.edu.unsam.phm.dto.IndividualDTO
import ar.edu.unsam.phm.service.IndividualService
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/individuals")
class IndividualController(
     val individualService: IndividualService
) {

     @ModelAttribute("currentUserId")
     fun getCurrentUserId(): Long {
          val usernamePAT = SecurityContextHolder.getContext().authentication
          return usernamePAT.principal.toString().toLong()
     }
     @GetMapping("/data")
     fun getProfileIndividual(@ModelAttribute("currentUserId") currentUserId: Long): IndividualDTO = IndividualDTO.toDTO(individualService.getById(currentUserId))

     @PatchMapping("/buy")
     fun buyItemFromStore(@RequestBody dto: BuyItemDTO) = individualService.buyItemFrom(dto)
}