package com.example.sportsdataservice.service

import com.example.sportsdataservice.dto.HeadCoachDTO
import com.example.sportsdataservice.model.HeadCoach
import com.example.sportsdataservice.repository.HeadCoachRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.persistence.EntityNotFoundException

@Service
class HeadCoachService(
    @Autowired private val headCoachRepository: HeadCoachRepository
) {
    fun getAll(): List<HeadCoachDTO> = headCoachRepository.findAll().map { it.toHeadCoachDTO() }

    fun getOne(id: Long): HeadCoachDTO = headCoachRepository.findById(id).orElse(null).toHeadCoachDTO()

    fun createOne(headCoachDTO: HeadCoachDTO): HeadCoachDTO {
        val headCoach = HeadCoach(
            firstName = headCoachDTO.firstName,
            lastName = headCoachDTO.lastName,
            wins = headCoachDTO.wins,
            losses = headCoachDTO.losses,
            ties = headCoachDTO.ties
        )

        return headCoachRepository.save(headCoach).toHeadCoachDTO()
    }

    fun updateOne(id: Long, headCoachDTO: HeadCoachDTO): HeadCoachDTO {
        val headCoach = headCoachRepository.findById(id)
            .orElseThrow { EntityNotFoundException("Head Coach not found with id: $id") }

        headCoach.firstName = headCoachDTO.firstName
        headCoach.lastName = headCoachDTO.lastName
        headCoach.wins = headCoachDTO.wins
        headCoach.losses = headCoachDTO.losses
        headCoach.ties = headCoachDTO.ties

        return headCoachRepository.save(headCoach).toHeadCoachDTO()
    }
}