package com.example.sportsdataservice.service

import com.example.sportsdataservice.dto.*
import com.example.sportsdataservice.model.Team
import com.example.sportsdataservice.model.TeamStadium
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
        ids: List<Long>? = null
    ): List<TeamDTO> {
        return if (ids != null) {
            getTeamsById(ids)
        } else {
            getAllTeams()
        }
    }

    private fun getAllTeams(): List<TeamDTO> =
        teamRepository.findAll().map { it.toTeamDTO() }

    private fun getTeamsById(ids: List<Long>): List<TeamDTO> =
        ids.map { teamRepository.findById(it) }
            .filter { it.isPresent }
            .map { it.get().toTeamDTO() }


    fun updateTeam(id: Long, updatedTeam: TeamDTO): Long {
        val team = teamRepository.findById(id).orElseThrow { EntityNotFoundException() }

        updateTeamLocation(team, updatedTeam.location)
        updateTeamHeadCoach(team, updatedTeam.headCoach)
        updateTeamColors(team, updatedTeam.colors)
        updateTeamStadiums(team, updatedTeam.stadiums)

        team.apply {
            name = updatedTeam.name
            prefix = updatedTeam.prefix
            establishedDate = updatedTeam.establishedDate
            fightSong = updatedTeam.fightSong
            mascot = updatedTeam.mascot
        }

        try {
            return teamRepository.save(team).id
        } catch (e: Exception) {
            throw IllegalStateException()
        }
    }

    private fun updateTeamLocation(team: Team, updatedLocation: LocationDTO?) {
        updatedLocation?.let { location ->
            team.location = locationRepository.findById(location.id)
                .orElseThrow { EntityNotFoundException() }
        }
    }

    private fun updateTeamHeadCoach(team: Team, updatedHeadCoach: HeadCoachDTO?) {
        updatedHeadCoach?.let { headCoach ->
            team.headCoach = headCoachRepository.findById(headCoach.id)
                .orElseThrow { EntityNotFoundException() }
        }
    }

    private fun updateTeamColors(team: Team, updatedColors: List<ColorDTO>?) {
        updatedColors?.let { colors ->
            team.colors = colors.map { colorDto ->
                colorRepository.findById(colorDto.id)
                    .orElseThrow { EntityNotFoundException() }
            }
        }
    }

    private fun updateTeamStadiums(team: Team, updatedStadiums: List<StadiumDTO>?) {
        updatedStadiums?.let { stadiums ->
            team.teamStadiums = stadiums.map { stadiumDto ->
                val stadiumEntity = stadiumRepository.findById(stadiumDto.id)
                    .orElseThrow { EntityNotFoundException() }
                TeamStadium(1, team, stadiumEntity, stadiumDto.fromDate, stadiumDto.toDate)
            }
        }
    }
}