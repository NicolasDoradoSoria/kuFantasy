package ar.edu.unsam.phm.controllers

import ar.edu.unsam.phm.dto.IndividualDTO
import ar.edu.unsam.phm.service.IndividualService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/individuals")
@CrossOrigin("*")
class IndividualController(
     val individualService: IndividualService
) {

     @GetMapping("/data/{idIndividual}")
     fun getProfileIndividual(@PathVariable idIndividual: Long): IndividualDTO = IndividualDTO.toDTO(individualService.getProfileIndividual(idIndividual))
}