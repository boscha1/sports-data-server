package com.example.sportsdataservice.model.response

import com.example.sportsdataservice.dto.TeamDTO

data class TeamData(
    val data: TeamList
)

data class TeamList(
    val teams: List<TeamDTO>
)