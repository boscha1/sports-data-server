package com.example.sportsdataservice.repository

import com.example.sportsdataservice.model.Color
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ColorRepository : CrudRepository<Color, Int>