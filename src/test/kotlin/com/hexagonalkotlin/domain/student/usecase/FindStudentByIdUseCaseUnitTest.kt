package com.hexagonalkotlin.domain.student.usecase

import com.hexagonalkotlin.domain.student.Student
import com.hexagonalkotlin.domain.student.exceptions.StudentNotFoundException
import com.hexagonalkotlin.domain.student.ports.output.StudentPersistenceInterface
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class FindStudentByIdUseCaseUnitTest {

    @Mock
    lateinit var studentPersistence: StudentPersistenceInterface

    @InjectMocks
    lateinit var findStudentByIdUseCase: FindStudentByIdUseCaseImpl

    @Test
    fun `should find a student by id`() {
        val student = Student("1", "John Doe")
        Mockito.`when`(studentPersistence.findById("1")).then { student }

        val result = findStudentByIdUseCase.findById("1")

        assertEquals(student, result)
    }

    @Test
    fun `should throw an exception when student not found by id`() {
        Mockito.`when`(studentPersistence.findById("1")).then { null }

        val exception = assertThrows<StudentNotFoundException> {
            findStudentByIdUseCase.findById("1")
        }

        assertEquals("Student with id: 1 not found!", exception.message)
    }
}