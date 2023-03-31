package com.example.sportsdataservice.dto

import com.example.sportsdataservice.model.Stadium
import java.util.*

data class StadiumDTO(
    val id: Long = 0,
    var name: String = "",
    var fromDate: Date = Date(),
    var toDate: Date? = Date()
)