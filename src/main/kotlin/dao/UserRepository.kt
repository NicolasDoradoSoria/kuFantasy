package ar.edu.unsam.phm.dao

import ar.edu.unsam.phm.models.User
import org.springframework.stereotype.Component

@Component
class UserRepository : Repository<User>() {
  fun findByMail(mail: String): User? = this.elements.find { it.mail == mail }
}