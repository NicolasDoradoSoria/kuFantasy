package ar.edu.unsam.phm.service

import ar.edu.unsam.phm.dao.ItemRepository
import org.springframework.stereotype.Service

@Service
class ItemService(
    val itemRepository: ItemRepository
) {

}