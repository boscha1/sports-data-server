package com.example.sportsdataservice.model

import com.example.sportsdataservice.dto.LocationDTO
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Location(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,
    var city: String = "",
    var state: String = "",
    var state_code: String = "",
    var zip_code: String = ""
) {

    fun toLocationDTO(): LocationDTO =
        LocationDTO(
            this.id,
            this.city,
            this.state,
            this.state_code,
            this.zip_code
        )
}