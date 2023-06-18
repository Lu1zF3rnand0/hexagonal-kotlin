package com.hexagonalkotlin.domain.student.ports.input

import com.hexagonalkotlin.domain.student.Student

fun interface FindStudentByIdUseCaseInterface {
    fun findById(id: String): Student
}