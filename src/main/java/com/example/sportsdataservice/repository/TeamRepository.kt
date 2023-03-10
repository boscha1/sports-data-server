package com.example.sportsdataservice.repository

import com.example.sportsdataservice.model.Team
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TeamRepository : JpaRepository<Team, String>