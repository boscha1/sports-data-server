package com.example.sportsdataservice.dto

import com.example.sportsdataservice.model.Location;

data class LocationDTO(
    val id: Long = 0,
    var city: String = "",
    var state: String = "",
    var state_code: String = "",
    var zip_code: String = ""
) {
    fun toLocation(): Location =
        Location(
            this.id,
            this.city,
            this.state,
            this.state_code,
            this.zip_code
        )
}