package com.example.sportsdataservice.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("color")
data class Color(
    @Id val id: Int? = null,
    var name: String = ""
)
