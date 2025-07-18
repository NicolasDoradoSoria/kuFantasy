package ar.edu.unsam.phm.dao

import ar.edu.unsam.phm.models.Race
import org.springframework.data.repository.CrudRepository

interface RaceRepository : CrudRepository<Race, Long>