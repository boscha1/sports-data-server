package com.example.sportsdataservice.controller

import com.example.sportsdataservice.model.response.TeamData
import com.example.sportsdataservice.model.response.TeamList
import com.example.sportsdataservice.service.TeamService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1/teams")
@CrossOrigin(origins = ["http://localhost:3000"])
class TeamController(
    @Autowired private val teamService: TeamService
) {
    @GetMapping(
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun readAll(): ResponseEntity<TeamData> {
        val teams = teamService.getTeams()
        return ResponseEntity.ok(TeamData(TeamList(teams)))
    }

    @GetMapping(
        value = ["{ids}"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getTeamsById(@PathVariable("ids") teamIds: List<Long>): ResponseEntity<TeamData> {
        val teams = teamService.getTeams(teamIds)
        return ResponseEntity.ok(TeamData(TeamList(teams)))
    }

//    @PutMapping(
//        value = ["{id}"],
//        consumes = [MediaType.APPLICATION_JSON_VALUE],
//        produces = [MediaType.APPLICATION_JSON_VALUE],
//    )
//    fun update(@PathVariable("id") id: Long, @RequestBody teamDTO: TeamDTO): ResponseEntity<Long> {
//        val teamId = teamService.updateTeam(id, teamDTO)
//        return ResponseEntity.ok(teamId)
//    }
}