package ar.edu.unsam.phm.service

import ar.edu.unsam.phm.dao.HouseRepository

import org.springframework.stereotype.Service

@Service
class HouseService (
   val houseRepository: HouseRepository,
) {
   fun getById(houseId: Long) =
      houseRepository.getById(houseId) ?: throw Exception("No existe una casa con el id de house: $houseId")

}