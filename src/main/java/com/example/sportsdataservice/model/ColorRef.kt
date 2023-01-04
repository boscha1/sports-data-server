package com.example.sportsdataservice.model

import org.springframework.data.relational.core.mapping.Table

@Table("team_color")
data class ColorRef(
    val color: Int
)