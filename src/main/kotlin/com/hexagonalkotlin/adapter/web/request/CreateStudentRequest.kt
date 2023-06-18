package com.hexagonalkotlin.adapter.web.request

import com.hexagonalkotlin.domain.student.Student

data class CreateStudentRequest(var name: String) {
    fun toStudent() = Student(name = name)
}