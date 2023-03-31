package com.example.sportsdataservice.service

import com.example.sportsdataservice.model.Color
import com.example.sportsdataservice.model.HeadCoach
import com.example.sportsdataservice.model.Location
import com.example.sportsdataservice.model.Team
import com.example.sportsdataservice.repository.*
import io.mockk.every
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import io.mockk.mockk

import java.util.*

class TeamServiceTest {
    private val teamRepository: TeamRepository = mockk()
    private val locationRepository: LocationRepository = mockk()
    private val headCoachRepository: HeadCoachRepository = mockk()
    private val colorRepository: ColorRepository = mockk()
    private val stadiumRepository: StadiumRepository = mockk()

    private val objectUnderTest = TeamService(
        teamRepository = teamRepository,
        headCoachRepository = headCoachRepository,
        locationRepository = locationRepository,
        colorRepository = colorRepository,
        stadiumRepository = stadiumRepository
    )

//    @Test
//    fun `should get a team successfully`() {
//
//    }
//
//    @Test
//    fun `should update a team successfully`() {
//        // Arrange
//        val oldTeam = Team(
//            id = 1L,
//            name = "Old Team Name",
//            prefix = "OLD",
//            establishedDate = Date(),
//            fightSong = "Old Fight Song",
//            mascot = "Old Mascot",
//            location = Location(
//                id = 1L,
//                city = "Old City",
//                state = "Old State",
//                state_code = "Old State Code",
//                zip_code = "Old Zip Code"
//            ),
//            headCoach = HeadCoach(
//                id = 1L,
//                firstName = "Old First Name",
//                lastName = "Old Last Name",
//                wins = 1,
//                losses = 1,
//                ties = 1
//            ),
//            colors = listOf(
//                Color(id = 1L, name = "Old Color")
//            )
//        )
//
//        val newTeam = Team(
//            id = oldTeam.id,
//            name = "New Name",
//            prefix = "New Prefix",
//            establishedDate = Date(),
//            fightSong = "New FightSong",
//            mascot = "New Mascot",
//            location = Location(
//                id = 2L,
//                city = "New City",
//                state = "New State",
//                state_code = "New State Code",
//                zip_code = "New Zip Code"
//            ),
//            headCoach = HeadCoach(
//                id = 2L,
//                firstName = "New First Name",
//                lastName = "New Last Name",
//                wins = 2,
//                losses = 2,
//                ties = 2
//            ),
//            colors = listOf(
//                Color(id = 2L, name = "New Color 1")
//            )
//        )
//
//        // When
//        every { (teamRepository.findById(any())) } returns Optional.of(oldTeam)
//        every { locationRepository.findById(any()) } returns Optional.of(oldTeam.location)
//        every { headCoachRepository.findById(any()) } returns Optional.of(oldTeam.headCoach)
//        every { colorRepository.findById(any()) } returns Optional.of(oldTeam.colors.first())
//        every { teamRepository.save(any()).toTeamDTO() } returns newTeam.toTeamDTO()
//
//        // Act
//        val result = objectUnderTest.updateTeam(oldTeam.id, oldTeam.toTeamDTO())
//
//        // Assert
//        assertEquals(newTeam.toTeamDTO(), result)
//    }
}
