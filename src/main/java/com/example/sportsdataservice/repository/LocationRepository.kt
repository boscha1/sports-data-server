package com.example.sportsdataservice.repository

import com.example.sportsdataservice.model.Location
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LocationRepository: JpaRepository<Location, Long>