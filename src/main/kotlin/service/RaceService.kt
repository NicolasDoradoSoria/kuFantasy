package ar.edu.unsam.phm.service

import ar.edu.unsam.phm.dao.RaceRepository
import org.springframework.stereotype.Component

@Component
class RaceService(private val raceRepository: RaceRepository) {

  fun getRaces() = raceRepository.findAll().toList()
}