package com.example.sportsdataservice.model

import com.example.sportsdataservice.dto.TeamDTO
import java.util.*
import javax.persistence.*


@Entity
data class Team(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,
    var name: String = "",
    var establishedDate: Date = Date(),
    var stadium: String = "",
    var fightSong: String? = null,
    var mascot: String? = null,
    @OneToOne
    var location: Location = Location(),
    @OneToOne
    var headCoach: HeadCoach = HeadCoach(),
    @ManyToMany
    var colors: List<Color> = emptyList()
) {
    fun toTeamDTO(): TeamDTO =
        TeamDTO(
            this.id,
            this.name,
            this.establishedDate,
            this.stadium,
            this.fightSong,
            this.mascot,
            this.location.toLocationDTO(),
            this.headCoach.toHeadCoachDTO(),
            this.colors.map { it.toColorDTO() }
        )
}