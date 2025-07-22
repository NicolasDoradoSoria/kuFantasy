package ar.edu.unsam.phm.dao

import ar.edu.unsam.phm.models.House
import ar.edu.unsam.phm.models.Place
import ar.edu.unsam.phm.models.Store
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface PlaceRepository : CrudRepository<Place, Long>{
  @Query("SELECT h FROM House h WHERE h.parentLocation.id = :territoryId")
  fun findHousesByTerritoryId(@Param("territoryId") territoryId: Long): List<House>

  @Query("SELECT s FROM Store s WHERE s.parentLocation.id = :territoryId")
  fun findStoresByTerritoryId(@Param("territoryId") territoryId: Long): List<Store>
}