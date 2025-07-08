package ar.edu.unsam.phm.config

import ar.edu.unsam.phm.security.JwtAuthFilter
import ar.edu.unsam.phm.utils.FRONTEND_URL
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
@EnableWebSecurity
class SecurityConfig {

  @Autowired
  lateinit var jwtAuthFilter: JwtAuthFilter

  @Bean @Throws(Exception::class)
  fun authenticationManager(authConfig: AuthenticationConfiguration): AuthenticationManager = authConfig.authenticationManager

  @Bean
  fun corsConfig(): WebMvcConfigurer {
    return object : WebMvcConfigurer {
      override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
          .allowedOrigins(FRONTEND_URL)
          .allowedHeaders("*")
          .allowedMethods("POST", "GET","PATCH", "DELETE", "PUT")
          .allowCredentials(true)
      }
    }
  }

  @Bean
  fun securityFilterChain(httpSecurity: HttpSecurity): SecurityFilterChain {
    return httpSecurity
      .cors {  }
      .csrf { it.disable() }
      .authorizeHttpRequests {
        it.requestMatchers(
          "/kuFantasyApp-api/**",
          "/registration/",
          "/registration/confirm",
          "/login/**",
          "/recovery",
          "/recovery/confirm",
          "/expiredSession",
          "/error"
        ).permitAll()

        it.requestMatchers(HttpMethod.OPTIONS).permitAll()


        it
          .requestMatchers(HttpMethod.GET, "/items/**", "/individuals/**", "/territories/**", "/houses/**").permitAll()
          .requestMatchers("/registration/confirm", "/recovery/**", "/expiredSession", "/error").permitAll()
          .requestMatchers(HttpMethod.OPTIONS).permitAll()
          .anyRequest().authenticated()
      }
      .httpBasic(
        Customizer.withDefaults())
      .sessionManagement {
          configurer -> configurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
      .addFilterBefore(
        jwtAuthFilter, UsernamePasswordAuthenticationFilter::class.java)
      .exceptionHandling(Customizer.withDefaults())
      .build()
  }
}