package com.hexagonalkotlin.domain.student.usecase

import com.hexagonalkotlin.domain.enums.ErrorCodes.HEXK01
import com.hexagonalkotlin.domain.student.Student
import com.hexagonalkotlin.domain.student.exceptions.StudentNotFoundException
import com.hexagonalkotlin.domain.student.ports.input.FindStudentByIdUseCaseInterface
import com.hexagonalkotlin.domain.student.ports.output.StudentPersistenceInterface

class FindStudentByIdUseCaseImpl(
        private val studentPersistence: StudentPersistenceInterface
) : FindStudentByIdUseCaseInterface {

    override fun findById(id: String): Student {
        return studentPersistence.findById(id)
                ?: throw StudentNotFoundException(HEXK01.msg.format("Student with id: $id"), HEXK01.code)
    }
}