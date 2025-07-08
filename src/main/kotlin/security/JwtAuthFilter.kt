package ar.edu.unsam.phm.security

import ar.edu.unsam.phm.utils.exceptions.InvalidTokenException
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class JwtAuthFilter : OncePerRequestFilter() {

  @Autowired
  lateinit var jwtTokenUtils: JwtTokenUtils

  override fun doFilterInternal(
    request: HttpServletRequest,
    response: HttpServletResponse,
    filterChain: FilterChain
  ){
    try {
      val bearerOfToken = request.getHeader("Authorization")

      if (bearerOfToken != null && bearerOfToken.startsWith("Bearer ")) {
        val token = bearerOfToken.substringAfter("Bearer ")
        val usernamePAT = jwtTokenUtils.getAuthentication(token)
        SecurityContextHolder.getContext().authentication = usernamePAT
        logger.info("usernamePostAuthToken: $usernamePAT")
      }

      filterChain.doFilter(request, response)

    } catch (e: InvalidTokenException) {
      logger.warn(e.message)
      response.sendError(401, e.message)
      return
    }
  }
}