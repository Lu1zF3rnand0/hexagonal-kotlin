package com.hexagonalkotlin.adapter.web.response

import com.hexagonalkotlin.domain.student.Student

data class StudentResponse(
        var id: String = "",
        var name: String = ""
)

fun Student.toStudentResponse() = StudentResponse(
        id = id!!,
        name = name
)