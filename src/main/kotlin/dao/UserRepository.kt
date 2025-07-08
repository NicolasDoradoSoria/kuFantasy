package ar.edu.unsam.phm.dao

import ar.edu.unsam.phm.models.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : CrudRepository<User, Long> {
  fun findByMail(mail: String): Optional<User>
}