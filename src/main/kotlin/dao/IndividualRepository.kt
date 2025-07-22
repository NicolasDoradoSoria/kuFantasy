package ar.edu.unsam.phm.dao

import ar.edu.unsam.phm.models.Individual
import ar.edu.unsam.phm.utils.UserType
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface IndividualRepository : CrudRepository<Individual, Long>{

  fun findByCurrentLocacionIdAndType(territoryId : Long, type: UserType) : List<Individual>
}