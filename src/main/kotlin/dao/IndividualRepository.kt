package ar.edu.unsam.phm.dao

import ar.edu.unsam.phm.models.Individual
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface IndividualRepository : CrudRepository<Individual, Long>