package ar.edu.unsam.phm.controllers

import ar.edu.unsam.phm.dto.TakeItemFromPlaceDTO

import ar.edu.unsam.phm.service.PlaceService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/place")
@CrossOrigin("*")

class PlaceController(
  private val placeService: PlaceService
) {
  @PatchMapping("/pickup")
  fun pickUpItemFromPlace(@RequestBody dto: TakeItemFromPlaceDTO) = placeService.pickUpItem(dto)
}