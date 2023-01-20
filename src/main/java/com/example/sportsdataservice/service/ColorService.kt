package com.example.sportsdataservice.service

import com.example.sportsdataservice.model.Color
import com.example.sportsdataservice.repository.ColorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ColorService(
    private val colorRepository: ColorRepository
) {
    fun getAll(): MutableIterable<Color> = colorRepository.findAll()
}