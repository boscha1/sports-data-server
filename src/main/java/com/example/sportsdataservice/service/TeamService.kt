package com.example.sportsdataservice.service

import com.example.sportsdataservice.model.Team
import com.example.sportsdataservice.repository.TeamRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class TeamService(
    @Autowired private val teamRepository: TeamRepository
) {
    fun getAll(): MutableIterable<Team> = teamRepository.findAll()

    fun getOne(id: Int): Optional<Team> = teamRepository.findById(id)

    fun saveOne(team: Team): Team = teamRepository.save(team)

    fun updateOne(newTeam: Team, id: Int): Team {
        val team = teamRepository.findById(id).get()

        team.name = newTeam.name
        team.establishedDate = newTeam.establishedDate
        team.stadium = newTeam.stadium
        team.fightSong = newTeam.fightSong
        team.mascot = newTeam.mascot
        team.location = newTeam.location
        team.headCoach = newTeam.headCoach
        team.colorIds = newTeam.colorIds

        return teamRepository.save(team)
    }
}