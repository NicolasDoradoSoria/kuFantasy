package ar.edu.unsam.phm.service

import org.springframework.stereotype.Service

@Service
class InventoryService (
  private val placeService: PlaceService,
  private val individualService: IndividualService
) {

}