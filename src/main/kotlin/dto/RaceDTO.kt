package ar.edu.unsam.phm.dto

import ar.edu.unsam.phm.models.Race

data class RaceDTO(
  val id: Long,
  val name: String,
  val description: String,
  val imageUrl: String,
  val baseStats: BaseStatsDTO,
  val colorTheme: ColorThemeDTO
){
  companion object{
    fun from (race: Race) : RaceDTO = RaceDTO(
      id = race.id,
      name = race.name,
      description = race.description,
      imageUrl = race.imageUrl,
      baseStats = BaseStatsDTO.from(race),
      colorTheme = ColorThemeDTO.from(race.colorTheme)
    )
  }
}