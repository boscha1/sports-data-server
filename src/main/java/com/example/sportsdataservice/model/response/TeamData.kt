package com.example.sportsdataservice.model.response

import com.example.sportsdataservice.dto.TeamDTO
import com.example.sportsdataservice.model.Team

data class TeamData(
    val data: TeamList
)

data class TeamList(
    val teams: List<TeamDTO>
)