package ar.edu.unsam.phm.dao

import ar.edu.unsam.phm.models.Store
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface StoreRepository : CrudRepository<Store, Long>