package com.example.sportsdataservice.dto

import com.example.sportsdataservice.model.Color

data class ColorDTO(
    val id: Long = 0,
    var name: String = ""
) {

    fun toColor(): Color =
        Color(
            this.id,
            this.name
        )
}