package ar.edu.unsam.phm.dao

import ar.edu.unsam.phm.models.Item
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ItemRepository : CrudRepository<Item, Long>