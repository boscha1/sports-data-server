package com.example.sportsdataservice.model

import org.springframework.data.relational.core.mapping.Table

@Table("head_coach")
data class HeadCoach(
    val firstName: String = "",
    val lastName: String = "",
    val wins: Int = -1,
    val losses: Int = -1,
    val ties: Int = -1
)
