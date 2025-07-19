package ar.edu.unsam.phm.controllers

import ar.edu.unsam.phm.dto.RaceDTO
import ar.edu.unsam.phm.dto.TerritorySummaryDTO
import ar.edu.unsam.phm.service.RaceService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/races")
class RaceController (val raceService: RaceService) {

  @GetMapping
  fun getAll(): List<RaceDTO> = raceService.getRaces().map{ RaceDTO.from(it) }

}