package ar.edu.unsam.phm.dao

import ar.edu.unsam.phm.models.Enemy
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface EnemyRepository : CrudRepository<Enemy, Long>