package com.example.sportsdataservice.model

import com.example.sportsdataservice.model.Color
import com.example.sportsdataservice.model.ColorRef
import com.example.sportsdataservice.model.HeadCoach
import com.example.sportsdataservice.model.Location
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.*
import java.util.stream.Collectors
import kotlin.collections.HashSet


@Table("team")
data class Team(
    @Id
    val id: Int? = null,
    var name: String = "",
    var establishedDate: Date = Date(),
    var stadium: String = "",
    var fightSong: String? = null,
    var mascot: String? = null,
    var location: Location = Location(),
    var headCoach: HeadCoach = HeadCoach(),
    var colorIds: MutableSet<ColorRef> = HashSet()
) {
    fun addColor(color: Color) = this.colorIds.add(ColorRef(color.id!!))

    fun fetchColorIds(): Set<Int> = this.colorIds.stream()
        .map(ColorRef::color)
        .collect(Collectors.toSet())
}