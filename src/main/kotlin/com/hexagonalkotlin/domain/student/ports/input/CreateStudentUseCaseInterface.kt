package com.hexagonalkotlin.domain.student.ports.input

import com.hexagonalkotlin.domain.student.Student

fun interface CreateStudentUseCaseInterface {
    fun save(student: Student): Student
}