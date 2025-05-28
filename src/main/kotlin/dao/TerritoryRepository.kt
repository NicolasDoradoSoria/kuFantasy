package ar.edu.unsam.phm.dao

import ar.edu.unsam.phm.models.Territory
import org.springframework.stereotype.Component

@Component
class TerritoryRepository : Repository<Territory>(){
  fun getAll(): List<Territory> = elements.toList()
}