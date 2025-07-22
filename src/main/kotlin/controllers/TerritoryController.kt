package ar.edu.unsam.phm.controllers

import ar.edu.unsam.phm.dto.TerritoryDetailDTO
import ar.edu.unsam.phm.dto.TerritoryPreviewDTO
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

  @GetMapping("/{id}/preview")
  fun getTerritory(@PathVariable id: Long) : TerritoryPreviewDTO =
    TerritoryPreviewDTO.from(territoryService.getTerritoryById(id))

  @GetMapping("/{id}/full")
  fun getTerritoryFull(@PathVariable id: Long): TerritoryDetailDTO =
    territoryService.getTerritoryDetails(id)

}