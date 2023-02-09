package com.example.sportsdataservice.dto

import com.example.sportsdataservice.model.Stadium

data class StadiumDTO(
    val id: Long = 0,
    var name: String = ""
) {
    fun toStadium(): Stadium =
        Stadium(
            this.id,
            this.name
        )
}