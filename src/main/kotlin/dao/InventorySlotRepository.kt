package ar.edu.unsam.phm.dao

import ar.edu.unsam.phm.models.InventorySlot
import org.springframework.data.repository.CrudRepository

interface InventorySlotRepository : CrudRepository<InventorySlot, Long>