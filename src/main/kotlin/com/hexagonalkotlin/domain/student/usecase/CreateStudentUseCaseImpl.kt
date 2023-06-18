package com.hexagonalkotlin.domain.student.usecase

import com.hexagonalkotlin.domain.enums.ErrorCodes
import com.hexagonalkotlin.domain.enums.ErrorCodes.*
import com.hexagonalkotlin.domain.student.Student
import com.hexagonalkotlin.domain.student.exceptions.InvalidStudentException
import com.hexagonalkotlin.domain.student.ports.input.CreateStudentUseCaseInterface
import com.hexagonalkotlin.domain.student.ports.output.StudentPersistenceInterface

class CreateStudentUseCaseImpl(
        private val studentPersistence: StudentPersistenceInterface
) : CreateStudentUseCaseInterface {

    override fun save(student: Student): Student {
        if (!student.isValid()) {
            throw InvalidStudentException(HEXK02.msg.format("Student is"), HEXK02.code)
        }
        return studentPersistence.save(student)
    }

}