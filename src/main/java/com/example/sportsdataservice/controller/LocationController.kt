package com.example.sportsdataservice.controller

import com.example.sportsdataservice.dto.LocationDTO
import com.example.sportsdataservice.dto.TeamDTO
import com.example.sportsdataservice.service.LocationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/locations")
@CrossOrigin(origins = ["http://localhost:3000"])
class LocationController(
    @Autowired private val locationService: LocationService
) {
    @GetMapping("/")
    fun readAll() = ResponseEntity.ok(locationService.getAll())

    @GetMapping("/{id}")
    fun read(@PathVariable id: Long) = ResponseEntity.ok(locationService.getOne(id))

    @PostMapping("/")
    fun create(@RequestBody locationDTO: LocationDTO) = ResponseEntity.ok(locationService.createOne(locationDTO))

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody locationDTO: LocationDTO) = ResponseEntity.ok(locationService.updateOne(id, locationDTO))
}