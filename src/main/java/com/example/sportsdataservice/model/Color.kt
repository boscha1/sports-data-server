package com.example.sportsdataservice.model

import com.example.sportsdataservice.dto.ColorDTO
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Color(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,
    var name: String = "",
    var hexCode: String = ""
) {

    fun toColorDTO(): ColorDTO =
        ColorDTO(
            this.id,
            this.name,
            this.hexCode
        )
}