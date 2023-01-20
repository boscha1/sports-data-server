package com.example.sportsdataservice.repository

import com.example.sportsdataservice.model.HeadCoach
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface HeadCoachRepository: JpaRepository<HeadCoach, Long>