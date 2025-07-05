package ar.edu.unsam.phm.service

import ar.edu.unsam.phm.dao.PlaceRepository
import ar.edu.unsam.phm.dto.TakeItemFromPlaceDTO
import ar.edu.unsam.phm.models.PickUpItemCommand
import ar.edu.unsam.phm.models.Place
import org.springframework.stereotype.Component

@Component
class PlaceService(
    private val placeRepository: PlaceRepository,
    private val individualService: IndividualService
) {
  fun getById(placeId: Long): Place = placeRepository.findById(placeId).orElseThrow{throw Exception("No existe una casa con el id de place: $placeId")}
  fun update(place: Place) = placeRepository.save(place)

  fun pickUpItem(takeItemFromPlaceDTO: TakeItemFromPlaceDTO) {
    val individual = individualService.getById(takeItemFromPlaceDTO.individualId)
    val place = this.getById(takeItemFromPlaceDTO.placeId)
    val item = place.getItemById(takeItemFromPlaceDTO.itemId)
    PickUpItemCommand(individual, item.item, place).execute()

    individualService.update(individual)
    this.update(place)

  }
}