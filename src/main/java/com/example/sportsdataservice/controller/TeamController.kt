package com.example.sportsdataservice.controller

import com.example.sportsdataservice.model.Team
import com.example.sportsdataservice.service.TeamService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/team")
@CrossOrigin(origins = ["http://localhost:3000"])
class TeamController(
    @Autowired private val teamService: TeamService
) {
    @GetMapping("/")
    fun readAll() = teamService.getAll()

    @GetMapping("/{id}")
    fun read(@PathVariable id: Int) = teamService.getOne(id)

    @PostMapping("/")
    fun create(@RequestBody team: Team) = teamService.saveOne(team)

    @PutMapping("/{id}")
    fun update(@RequestBody team: Team, @PathVariable id: Int) = teamService.updateOne(team, id)
}