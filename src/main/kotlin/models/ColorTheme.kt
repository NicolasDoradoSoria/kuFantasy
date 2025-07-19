package ar.edu.unsam.phm.models

import jakarta.persistence.Embeddable

@Embeddable
class ColorTheme {
  lateinit var primaryColor: String
  lateinit var secondaryColor: String
  lateinit var bgColor: String
}