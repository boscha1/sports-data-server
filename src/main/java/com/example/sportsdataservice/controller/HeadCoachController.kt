package com.example.sportsdataservice.controller

import com.example.sportsdataservice.dto.HeadCoachDTO
import com.example.sportsdataservice.service.HeadCoachService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/head-coaches")
@CrossOrigin(origins = ["http://localhost:3000"])
class HeadCoachController(
    @Autowired private val headCoachService: HeadCoachService
) {
    @GetMapping("/")
    fun readAll() = ResponseEntity.ok(headCoachService.getAll())

    @GetMapping("/{id}")
    fun read(@PathVariable id: Long) = ResponseEntity.ok(headCoachService.getOne(id))

    @PostMapping("/")
    fun create(@RequestBody headCoachDTO: HeadCoachDTO) = ResponseEntity.ok(headCoachService.createOne(headCoachDTO))

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody headCoachDTO: HeadCoachDTO) = ResponseEntity.ok(headCoachService.updateOne(id, headCoachDTO))
}