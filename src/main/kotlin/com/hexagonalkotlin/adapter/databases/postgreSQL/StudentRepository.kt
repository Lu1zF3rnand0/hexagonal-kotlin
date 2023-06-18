package com.hexagonalkotlin.adapter.databases.postgreSQL

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository : JpaRepository<StudentModel, String>