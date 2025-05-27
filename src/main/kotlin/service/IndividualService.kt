package ar.edu.unsam.phm.service

import ar.edu.unsam.phm.dao.IndividualRepository
import org.springframework.stereotype.Service

@Service
class IndividualService(val individualRepository: IndividualRepository) {
  fun getProfileIndividual(id: Long) = individualRepository.getById(id) ?: throw Exception("No existe un individuo con el id: $id")

}