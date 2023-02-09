package com.example.sportsdataservice.service

import com.example.sportsdataservice.dto.TeamDTO
import com.example.sportsdataservice.model.Team
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
    fun getAll(): List<TeamDTO> = teamRepository.findAll().map { it.toTeamDTO() }

    fun getOne(id: Long): TeamDTO = teamRepository.findById(id).orElse(null).toTeamDTO()

    fun createOne(teamDto: TeamDTO): Team {
        val location = locationRepository.findById(teamDto.location.id)
            .orElseThrow { EntityNotFoundException("Location not found with id: ${teamDto.location.id}") }
        val headCoach = headCoachRepository.findById(teamDto.headCoach.id)
            .orElseThrow { EntityNotFoundException("Head Coach not found with id: ${teamDto.headCoach.id}") }
        val colors = teamDto.colors.map { colorRepository.findById(it.id).orElseThrow { EntityNotFoundException("Color not found with id: ${it.id}") } }
        val stadiums = teamDto.stadiums.map { stadiumRepository.findById(it.id).orElseThrow { EntityNotFoundException("Stadium not found with id: ${it.id}") } }

        val team = Team(
            name = teamDto.name,
            establishedDate = teamDto.establishedDate,
            fightSong = teamDto.fightSong,
            mascot = teamDto.mascot,
            stadiums = stadiums,
            location = location,
            headCoach = headCoach,
            colors = colors
        )

        return teamRepository.save(team)
    }

    fun updateOne(id: Long, teamDto: TeamDTO): TeamDTO {
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
            team.stadiums = teamDto.stadiums.map {
                stadiumRepository.findById(it.id)
                    .orElseThrow { EntityNotFoundException("Stadium not found with id: ${it.id}") }
            }
        }

        team.name = teamDto.name
        team.establishedDate = teamDto.establishedDate
        team.fightSong = teamDto.fightSong
        team.mascot = teamDto.mascot

        return teamRepository.save(team).toTeamDTO()
    }
}