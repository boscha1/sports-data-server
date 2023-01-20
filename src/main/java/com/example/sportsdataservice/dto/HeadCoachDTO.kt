package com.example.sportsdataservice.dto

import com.example.sportsdataservice.model.HeadCoach

data class HeadCoachDTO(
    val id: Long = 0,
    val firstName: String = "",
    val lastName: String = "",
    val wins: Int = -1,
    val losses: Int = -1,
    val ties: Int = -1
) {

    fun toHeadCoach(): HeadCoach =
        HeadCoach(
            this.id,
            this.firstName,
            this.lastName,
            this.wins,
            this.losses,
            this.ties
        )
}