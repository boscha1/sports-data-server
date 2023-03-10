package com.example.sportsdataservice.dto

import com.example.sportsdataservice.model.Team
import java.util.*

data class TeamDTO(
    var id: String = "",
    var name: String = "",
    var prefix: String = "",
    var establishedDate: Date = Date(),
    var fightSong: String? = null,
    var mascot: String? = null,
    var stadiums: List<StadiumDTO> = emptyList(),
    var location: LocationDTO = LocationDTO(),
    var headCoach: HeadCoachDTO = HeadCoachDTO(),
    var colors: List<ColorDTO> = emptyList()
) {
    fun toTeam(): Team =
        Team(
            this.id,
            this.name,
            this.prefix,
            this.establishedDate,
            this.fightSong,
            this.mascot
        )
}