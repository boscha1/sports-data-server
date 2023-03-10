package com.example.sportsdataservice.model

import com.example.sportsdataservice.dto.TeamDTO
import java.util.*
import javax.persistence.*

@Entity
data class Team(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: String = "",
    var name: String = "",
    var prefix: String = "",
    var establishedDate: Date = Date(),
    var fightSong: String? = null,
    var mascot: String? = null,
    @OneToMany(mappedBy = "team", cascade = [CascadeType.ALL])
    var teamStadiums: List<TeamStadium> = emptyList(),
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
            this.prefix,
            this.establishedDate,
            this.fightSong,
            this.mascot,
            this.teamStadiums.map { it.stadium.toStadiumDTO() },
            this.location.toLocationDTO(),
            this.headCoach.toHeadCoachDTO(),
            this.colors.map { it.toColorDTO() }
        )

    override fun toString(): String {
        return "Team(" +
                    "id='$id', " +
                    "name='$name', " +
                    "prefix='$prefix', " +
                    "establishedDate=$establishedDate, " +
                    "fightSong=$fightSong, " +
                    "mascot=$mascot, " +
                    "teamStadiums=$teamStadiums, " +
                    "location=$location, " +
                    "headCoach=$headCoach, " +
                    "colors=$colors" +
                ")"
    }
}