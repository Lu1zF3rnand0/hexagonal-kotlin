package com.hexagonalkotlin.domain.student.usecase

import com.hexagonalkotlin.domain.student.Student
import com.hexagonalkotlin.domain.student.exceptions.InvalidStudentException
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
class CreateStudentUseCaseUnitTest {

    @Mock
    lateinit var studentPersistence: StudentPersistenceInterface

    @InjectMocks
    lateinit var createStudentUseCase: CreateStudentUseCaseImpl

    @Test
    fun `should create student`() {
        val studentToSave = Student("1", "John Doe")
        Mockito.`when`(studentPersistence.save(studentToSave)).then { studentToSave }

        val result = createStudentUseCase.save(studentToSave)

        assertEquals(studentToSave, result)
    }

    @Test
    fun `should throw exception when student not valid`(){
        val studentToSave = Student("1", "")

        val exception = assertThrows<InvalidStudentException> {
            createStudentUseCase.save(studentToSave)
        }

        assertEquals("Student is invalid!", exception.message)
    }
}