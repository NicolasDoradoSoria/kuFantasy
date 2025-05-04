package ar.edu.unsam.phm.controllers

import ar.edu.unsam.phm.service.IndividualService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/individuals")
@CrossOrigin("*")

class IndividualController(
     val individualService: IndividualService
) {

}