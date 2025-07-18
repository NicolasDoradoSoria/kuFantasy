package ar.edu.unsam.phm.models

import jakarta.persistence.Embeddable

@Embeddable
class ColorTheme {
  lateinit var primary: String
  lateinit var secondary: String
}