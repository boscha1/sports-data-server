package com.example.sportsdataservice.repository

import com.example.sportsdataservice.model.Stadium
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StadiumRepository: JpaRepository<Stadium, Long>