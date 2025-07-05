package ar.edu.unsam.phm.dao

import ar.edu.unsam.phm.models.Place
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository

@Repository
interface PlaceRepository : CrudRepository<Place, Long>