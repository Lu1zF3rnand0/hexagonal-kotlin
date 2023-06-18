package com.hexagonalkotlin.domain.student.ports.output

import com.hexagonalkotlin.domain.student.Student

interface StudentPersistenceInterface {
    fun save(student: Student): Student
    fun findById(id: String): Student?
}