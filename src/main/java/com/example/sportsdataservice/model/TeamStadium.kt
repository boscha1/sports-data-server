package com.example.sportsdataservice.model

import java.util.Date
import javax.persistence.*

@Entity
data class TeamStadium(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    val team: Team = Team(),

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stadium_id", referencedColumnName = "id")
    val stadium: Stadium = Stadium(),

    @Column(name = "from_date")
    val fromDate: Date = Date(),

    @Column(name = "to_date")
    val toDate: Date? = null
) {
    override fun toString(): String {
        return "TeamStadium(id=$id, team=${team.id}, stadium=${stadium.id}, fromDate=$fromDate, toDate=$toDate)"
    }
}
