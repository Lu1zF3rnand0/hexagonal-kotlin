package com.hexagonalkotlin.domain.student.usecase

import com.hexagonalkotlin.domain.BaseDatabaseIntegrationTest
import com.hexagonalkotlin.domain.student.Student
import com.hexagonalkotlin.domain.student.ports.input.FindStudentByIdUseCaseInterface
import com.hexagonalkotlin.domain.student.ports.output.StudentPersistenceInterface
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class FindStudentByIdIntegrationTest : BaseDatabaseIntegrationTest(){

    @Autowired
    lateinit var findStudentByIdUseCase: FindStudentByIdUseCaseInterface

    @Autowired
    lateinit var studentPersistence: StudentPersistenceInterface

    @Test
    fun `should find student by id`() {
        val studentToSave = Student("1", "John Doe")
        studentPersistence.save(studentToSave)

        val savedStudent = findStudentByIdUseCase.findById("1")

        assertEquals(studentToSave, savedStudent)
    }
}