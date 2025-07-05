package ar.edu.unsam.phm.service

import ar.edu.unsam.phm.dao.TerritoryRepository
import ar.edu.unsam.phm.models.Locacion
import ar.edu.unsam.phm.models.Store
import org.springframework.stereotype.Service

@Service
class TerritoryService(
  val territoryRepository: TerritoryRepository
) {
  fun getTerritories() =  territoryRepository.findAll().toList()


}