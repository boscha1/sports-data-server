package com.example.sportsdataservice.controller

import com.example.sportsdataservice.dto.ColorDTO
import com.example.sportsdataservice.service.ColorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/colors")
@CrossOrigin(origins = ["http://localhost:3000"])
class ColorController(@Autowired private val colorService: ColorService) {

    @GetMapping("/")
    fun readAll() = ResponseEntity.ok(colorService.getAll())

    @GetMapping("/{id}")
    fun read(@PathVariable id: Long) = ResponseEntity.ok(colorService.getOne(id))

    @PostMapping("/{id}")
    fun create(@RequestBody colorDTO: ColorDTO) = ResponseEntity.ok(colorService.createOne(colorDTO))

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody colorDTO: ColorDTO) = ResponseEntity.ok(colorService.updateOne(id, colorDTO))
}