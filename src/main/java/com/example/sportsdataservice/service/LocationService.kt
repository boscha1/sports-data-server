package com.example.sportsdataservice.service

import com.example.sportsdataservice.dto.LocationDTO
import com.example.sportsdataservice.model.Location
import com.example.sportsdataservice.repository.LocationRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.persistence.EntityNotFoundException

@Service
class LocationService(
    @Autowired private val locationRepository: LocationRepository
) {
    fun getAll(): List<LocationDTO> = locationRepository.findAll().map { it.toLocationDTO() }

    fun getOne(id: Long): LocationDTO = locationRepository.findById(id).orElse(null).toLocationDTO()

    fun createOne(locationDto: LocationDTO): LocationDTO {
        val location = Location(
            city = locationDto.city,
            state = locationDto.state,
            state_code = locationDto.state_code,
            zip_code = locationDto.zip_code
        )

        return locationRepository.save(location).toLocationDTO()
    }

    fun updateOne(id: Long, locationDto: LocationDTO): LocationDTO {
        val location = locationRepository.findById(id)
            .orElseThrow { EntityNotFoundException("Location not found with id: $id") }

        location.city = locationDto.city
        location.state = locationDto.state
        location.state_code = locationDto.state_code
        location.zip_code = locationDto.zip_code

        return locationRepository.save(location).toLocationDTO()
    }
}