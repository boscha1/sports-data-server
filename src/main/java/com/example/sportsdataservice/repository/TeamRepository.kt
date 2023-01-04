package com.example.sportsdataservice.repository

import com.example.sportsdataservice.model.Team
import org.springframework.data.repository.CrudRepository

interface TeamRepository : CrudRepository<Team, Int>