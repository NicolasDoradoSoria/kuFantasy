package ar.edu.unsam.phm.dao

import ar.edu.unsam.phm.models.TerritoryInfo
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TerritoryInfoRepository : CrudRepository<TerritoryInfo, Long>