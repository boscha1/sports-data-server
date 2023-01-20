package com.example.sportsdataservice.service

import com.example.sportsdataservice.dto.ColorDTO
import com.example.sportsdataservice.model.Color
import com.example.sportsdataservice.repository.ColorRepository
import org.springframework.stereotype.Service
import javax.persistence.EntityNotFoundException

@Service
class ColorService(
    private val colorRepository: ColorRepository
) {
    fun getAll(): List<ColorDTO> = colorRepository.findAll().map { it.toColorDTO() }

    fun getOne(id: Long): ColorDTO = colorRepository.findById(id).orElse(null).toColorDTO()

    fun createOne(colorDTO: ColorDTO): ColorDTO {
        val color = Color(
            name = colorDTO.name
        )

        return colorRepository.save(color).toColorDTO()
    }

    fun updateOne(id: Long, colorDTO: ColorDTO): ColorDTO {
        val color = colorRepository.findById(id)
            .orElseThrow { EntityNotFoundException("Color not found with id: $id") }

        color.name = colorDTO.name

        return colorRepository.save(color).toColorDTO()
    }
}