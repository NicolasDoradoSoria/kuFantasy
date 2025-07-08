package ar.edu.unsam.phm.controllers

import ar.edu.unsam.phm.dto.StoreDTO
import ar.edu.unsam.phm.dto.TerritoryDTO
import ar.edu.unsam.phm.models.Territory
import ar.edu.unsam.phm.service.TerritoryService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/territory")
class TerritoryController(
  val territoryService: TerritoryService
){
  @GetMapping("/")
  fun getTerritories(): List<TerritoryDTO> =
    territoryService.getTerritories().map{TerritoryDTO.from(it) }

}