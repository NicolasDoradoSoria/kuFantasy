package ar.edu.unsam.phm.controllers

import ar.edu.unsam.phm.dto.TerritoryDetailDTO
import ar.edu.unsam.phm.dto.TerritorySummaryDTO
import ar.edu.unsam.phm.service.TerritoryService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/territory")
class TerritoryController(
  val territoryService: TerritoryService
){
  @GetMapping("/")
  fun getTerritories(): List<TerritorySummaryDTO> =
    territoryService.getTerritories().map{TerritorySummaryDTO.from(it) }

  @GetMapping("/{id}")
  fun getTerritory(@PathVariable id: Long) : TerritoryDetailDTO =
    TerritoryDetailDTO.from(territoryService.getTerritoryById(id))
}