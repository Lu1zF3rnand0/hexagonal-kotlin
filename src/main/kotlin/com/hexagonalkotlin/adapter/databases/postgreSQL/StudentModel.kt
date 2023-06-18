package com.hexagonalkotlin.adapter.databases.postgreSQL

import com.hexagonalkotlin.domain.student.Student
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.util.UUID

@Entity(name = "students")
data class StudentModel(
        @Id
        var id: String = "",

        @Column
        var name: String = ""
) {
    fun toStudent(): Student {
        return Student(id, name)
    }
}

fun Student.toModel(): StudentModel {
    return StudentModel(id ?: UUID.randomUUID().toString(), name)
}