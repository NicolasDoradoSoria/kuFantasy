package ar.edu.unsam.phm.dao

import ar.edu.unsam.phm.models.Territory
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TerritoryRepository : CrudRepository<Territory, Long>