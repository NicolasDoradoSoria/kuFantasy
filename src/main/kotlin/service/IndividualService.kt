package ar.edu.unsam.phm.service

import ar.edu.unsam.phm.dao.IndividualRepository
import ar.edu.unsam.phm.dto.BuyItemDTO
import ar.edu.unsam.phm.models.*
import ar.edu.unsam.phm.utils.enums.UserType
import org.apache.coyote.BadRequestException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class IndividualService(val individualRepository: IndividualRepository, val raceService: RaceService) {

  fun getById(userId: Long): Individual = individualRepository.findById(userId).orElseThrow{ throw Exception("No existe un individuo con el id de individual: $userId") }

  fun update(individual: Individual) = individualRepository.save(individual)

  fun buyItemFrom(buyItemDTO: BuyItemDTO) {
    val buyer = this.getById(buyItemDTO.individualId)
    val seller = this.getById(buyItemDTO.sellerId)

    buyer.buyItemFrom(seller, buyItemDTO.itemId)
    update(buyer)
    update(seller)
  }

  @Transactional
  fun assignRaceToIndividual(idRace: Long, currentUserId: Long){
    val user = this.getById(currentUserId)

    if(user.race != null) throw BadRequestException("El personaje ya tiene una raza asignada")

    val race = raceService.getById(idRace)

    user.race =race
  }

  fun getByCurrentLocacionIdAndType(territoryId: Long) = individualRepository.findByCurrentLocacionIdAndType(territoryId, UserType.NPC)

}