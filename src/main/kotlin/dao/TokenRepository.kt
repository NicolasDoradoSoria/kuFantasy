package ar.edu.unsam.phm.dao

import ar.edu.unsam.phm.models.Token
import ar.edu.unsam.phm.models.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Component

@Component
interface TokenRepository : CrudRepository<Token, Long> {
    fun findByUserId(userId: Long): Token?
    fun findByValue(token: String): Token?
    fun getTokensByUser(user: User): Token
}