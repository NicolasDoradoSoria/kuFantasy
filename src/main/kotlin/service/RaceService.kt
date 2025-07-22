package ar.edu.unsam.phm.service

import ar.edu.unsam.phm.dao.RaceRepository
import ar.edu.unsam.phm.models.Race
import org.springframework.stereotype.Component

@Component
class RaceService(private val raceRepository: RaceRepository) {

  fun getById(raceId: Long): Race = raceRepository.findById(raceId).orElseThrow{ throw Exception("No existe una raza con el id: $raceId") }

  fun getRaces() = raceRepository.findAll().toList()
}