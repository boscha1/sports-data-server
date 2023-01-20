package com.example.sportsdataservice.dto

import com.example.sportsdataservice.model.Team
import java.util.*

data class TeamDTO(
    var id: Long = 0,
    var name: String = "",
    var establishedDate: Date = Date(),
    var stadium: String = "",
    var fightSong: String? = null,
    var mascot: String? = null,
    var location: LocationDTO = LocationDTO(),
    var headCoach: HeadCoachDTO = HeadCoachDTO(),
    var colors: List<ColorDTO> = emptyList()
) {
    fun toTeam(): Team =
        Team(
            this.id,
            this.name,
            this.establishedDate,
            this.stadium,
            this.fightSong,
            this.mascot
        )
}