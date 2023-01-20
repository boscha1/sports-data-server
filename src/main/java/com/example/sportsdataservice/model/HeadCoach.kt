package com.example.sportsdataservice.model

import com.example.sportsdataservice.dto.HeadCoachDTO
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class HeadCoach(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,
    var firstName: String = "",
    var lastName: String = "",
    var wins: Int = -1,
    var losses: Int = -1,
    var ties: Int = -1
) {

    fun toHeadCoachDTO(): HeadCoachDTO =
        HeadCoachDTO(
            this.id,
            this.firstName,
            this.lastName,
            this.wins,
            this.losses,
            this.ties
        )
}