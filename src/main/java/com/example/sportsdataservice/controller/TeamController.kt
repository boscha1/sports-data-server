package com.example.sportsdataservice.controller

import com.example.sportsdataservice.dto.TeamDTO
import com.example.sportsdataservice.service.TeamService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/teams")
@CrossOrigin(origins = ["http://localhost:3000"])
class TeamController(
    @Autowired private val teamService: TeamService
) {
    @GetMapping("/")
    fun readAll() = ResponseEntity.ok(teamService.getAll())

    @GetMapping("/{id}")
    fun read(@PathVariable id: Long) = ResponseEntity.ok(teamService.getOne(id))

    @PostMapping("/")
    fun createTeam(@RequestBody teamDTO: TeamDTO) = ResponseEntity.ok(teamService.createOne(teamDTO))

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody team: TeamDTO) = ResponseEntity.ok(teamService.updateOne(id, team))
}