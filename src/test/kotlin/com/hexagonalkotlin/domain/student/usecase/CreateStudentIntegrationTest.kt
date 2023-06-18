package com.hexagonalkotlin.domain.student.usecase

import com.hexagonalkotlin.domain.BaseDatabaseIntegrationTest
import com.hexagonalkotlin.domain.student.Student
import com.hexagonalkotlin.domain.student.ports.input.CreateStudentUseCaseInterface
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class CreateStudentIntegrationTest: BaseDatabaseIntegrationTest() {

    @Autowired
    lateinit var createStudentUseCase: CreateStudentUseCaseInterface

    @Test
    fun `should create student`() {
        val studentToSave = Student("1", "John Doe")

        val savedStudent = createStudentUseCase.save(studentToSave)

        assertEquals(studentToSave, savedStudent)
    }
}