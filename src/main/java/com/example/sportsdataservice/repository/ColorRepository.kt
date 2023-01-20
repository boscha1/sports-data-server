package com.example.sportsdataservice.repository

import com.example.sportsdataservice.model.Color
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ColorRepository : JpaRepository<Color, Long>