package com.example.sportsdataservice.model

import com.example.sportsdataservice.dto.StadiumDTO
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Stadium(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,
    var name: String = ""
) {
    fun toStadiumDTO(): StadiumDTO =
        StadiumDTO(
            this.id,
            this.name
        )
}