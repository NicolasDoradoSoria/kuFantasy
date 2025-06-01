package ar.edu.unsam.phm.service

import ar.edu.unsam.phm.dao.IndividualRepository
import ar.edu.unsam.phm.dto.BuyItemDTO
import ar.edu.unsam.phm.models.*
import org.springframework.stereotype.Service

@Service
class IndividualService(val individualRepository: IndividualRepository) {


  fun getById(userId: Long) = individualRepository.getById(userId) ?: throw Exception("No existe un individuo con el id de individual: $userId")
  fun update(individual: Individual) = individualRepository.update(individual)

  fun buyItemFrom(buyItemDTO: BuyItemDTO) {
    val buyer = this.getById(buyItemDTO.individualId)
    val seller = this.getById(buyItemDTO.sellerId)

    buyer.buyItemFrom(seller, buyItemDTO.itemId)
    update(buyer)
    update(seller)
  }

}