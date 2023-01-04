package com.example.sportsdataservice.model

import org.springframework.data.relational.core.mapping.Table

@Table("location")
data class Location(
    val city: String = "",
    val state: String = "",
    val state_code: String = "",
    val zip_code: String = ""
)
