package com.example.sportsdataservice.model

import com.example.sportsdataservice.dto.StadiumDTO
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
data class Stadium(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,
    var name: String = "",
    @OneToMany(mappedBy = "stadium", cascade = [CascadeType.ALL])
    var teamStadiums: List<TeamStadium> = emptyList(),
) {
    fun toStadiumDTO(): StadiumDTO =
        StadiumDTO(
            this.id,
            this.name,
            this.teamStadiums.first().fromDate,
            this.teamStadiums.first().toDate
        )

    override fun toString(): String {
        return "Stadium(" +
                    "id=$id, " +
                    "name='$name', " +
                    "teamStadiums=$teamStadiums" +
                ")"
    }
}