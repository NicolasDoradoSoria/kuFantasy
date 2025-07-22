package ar.edu.unsam.phm.service

import ar.edu.unsam.phm.dao.TerritoryRepository
import ar.edu.unsam.phm.dto.TerritoryDetailDTO
import ar.edu.unsam.phm.models.Territory
import ar.edu.unsam.phm.utils.exceptions.TerritoryException
import org.springframework.stereotype.Service

@Service
class TerritoryService(
  val territoryRepository: TerritoryRepository,
  val placeService: PlaceService,
  val individualService: IndividualService
) {
  fun getTerritories() =  territoryRepository.findAll().toList()

  fun getTerritoryById(id: Long): Territory =
    territoryRepository.findById(id).orElseThrow { throw TerritoryException("Ha habido un error al recuperar la información del territorio.") }
  fun getRandomTerritory(): Territory {
    if(getTerritories().isEmpty()) throw IllegalStateException("No hay territorios disponibles")

    return getTerritories().random()
  }

  fun getTerritoryDetails(id: Long): TerritoryDetailDTO {
    val territory = this.getTerritoryById(id)
    val houses = placeService.getHouses(id)
    val stores = placeService.getStores(id)
    val npcs = individualService.getByCurrentLocacionIdAndType(id)

    return TerritoryDetailDTO.from(territory, houses, stores, npcs)
  }


}