package ar.edu.unsam.phm.service

import ar.edu.unsam.phm.dao.TerritoryRepository
import ar.edu.unsam.phm.models.Territory
import ar.edu.unsam.phm.utils.exceptions.TerritoryException
import org.springframework.stereotype.Service

@Service
class TerritoryService(
  val territoryRepository: TerritoryRepository
) {
  fun getTerritories() =  territoryRepository.findAll().toList()

  fun getTerritoryById(id: Long): Territory =
    territoryRepository.findById(id).orElseThrow { throw TerritoryException("Ha habido un error al recuperar la información del territorio.") }
  fun getRandomTerritory() : Territory {
    if(getTerritories().isEmpty()) throw IllegalStateException("No hay territorios disponibles")

    return getTerritories().random()
  }

}