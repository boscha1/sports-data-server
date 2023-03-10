package com.example.sportsdataservice.service

import com.example.sportsdataservice.dto.TeamDTO
import com.example.sportsdataservice.repository.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.persistence.EntityNotFoundException

@Service
class TeamService(
    @Autowired private val teamRepository: TeamRepository,
    @Autowired private val headCoachRepository: HeadCoachRepository,
    @Autowired private val locationRepository: LocationRepository,
    @Autowired private val colorRepository: ColorRepository,
    @Autowired private val stadiumRepository: StadiumRepository
) {
    fun getTeams(
        ids: List<String>? = null
    ): List<TeamDTO> {
        return if (ids != null) {
            getTeamsById(ids)
        } else {
            getAllTeams()
        }
    }

    private fun getAllTeams(): List<TeamDTO> =
        teamRepository.findAll().map { it.toTeamDTO() }

    private fun getTeamsById(ids: List<String>): List<TeamDTO> =
        ids.map { teamRepository.findById(it) }
            .filter { it.isPresent }
            .map { it.get().toTeamDTO() }


    fun updateTeam(id: String, teamDto: TeamDTO): String {
        val team = teamRepository.findById(id)
            .orElseThrow { EntityNotFoundException("Team not found with id: $id") }

        val location = locationRepository.findById(teamDto.location.id)
            .orElseThrow { EntityNotFoundException("Location not found with id: ${teamDto.location.id}") }
        team.location = location

        val headCoach = headCoachRepository.findById(teamDto.headCoach.id)
            .orElseThrow { EntityNotFoundException("Head Coach not found with id: ${teamDto.headCoach.id}") }
        team.headCoach = headCoach

        if (teamDto.colors.isNotEmpty()) {
            team.colors = teamDto.colors.map {
                colorRepository.findById(it.id)
                    .orElseThrow { EntityNotFoundException("Color not found with id: ${it.id}") }
            }
        }

        if (teamDto.stadiums.isNotEmpty()) {
            team.teamStadiums.map {
                val stadiumId = it.stadium.id
                stadiumRepository.findById(stadiumId)
                    .orElseThrow { EntityNotFoundException("Stadium not found with id: $stadiumId") }
            }
        }

        team.name = teamDto.name
        team.prefix = teamDto.prefix
        team.establishedDate = teamDto.establishedDate
        team.fightSong = teamDto.fightSong
        team.mascot = teamDto.mascot

        return teamRepository.save(team).id
    }
}