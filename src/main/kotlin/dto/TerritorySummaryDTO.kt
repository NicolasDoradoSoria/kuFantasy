package ar.edu.unsam.phm.dto

import ar.edu.unsam.phm.models.Territory
import ar.edu.unsam.phm.utils.enums.Difficulty
import ar.edu.unsam.phm.utils.enums.TerritoryType

data class TerritorySummaryDTO(
    val id: Long,
    val name: String,
    val overview: String,
    val type: TerritoryType,
    val level: Int,
    val difficulty: Difficulty,
    val position: PositionDTO
) {
    companion object {
        fun from(territory: Territory): TerritorySummaryDTO =
            TerritorySummaryDTO(
                id = territory.id,
                name = territory.name,
                overview = territory.overview,
                type = territory.type,
                level = territory.level,
                difficulty = territory.difficulty,
                position = PositionDTO(territory.top, territory.left)
            )
    }
}