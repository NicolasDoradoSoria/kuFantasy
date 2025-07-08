package ar.edu.unsam.phm.service

import ar.edu.unsam.phm.dao.TerritoryRepository
import ar.edu.unsam.phm.models.Territory
import org.springframework.stereotype.Service

@Service
class TerritoryService(
  val territoryRepository: TerritoryRepository
) {
  fun getTerritories() =  territoryRepository.findAll().toList()

  fun getRandomTerritory() : Territory {
    if(getTerritories().isEmpty()) throw IllegalStateException("No hay territorios disponibles")

    return getTerritories().random()
  }

}