package ar.edu.unsam.phm.dto

import ar.edu.unsam.phm.models.ColorTheme

data class ColorThemeDTO(
  val primary : String,
  val secondary: String,
  val bgColor: String
){
  companion object {
    fun from(color: ColorTheme) = ColorThemeDTO(
      primary = color.primaryColor,
      secondary = color.secondaryColor,
      bgColor = color.bgColor
    )
  }
}