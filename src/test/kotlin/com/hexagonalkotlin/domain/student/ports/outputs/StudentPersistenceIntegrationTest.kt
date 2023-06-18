package com.hexagonalkotlin.domain.student.ports.outputs

import com.hexagonalkotlin.domain.BaseDatabaseIntegrationTest
import com.hexagonalkotlin.domain.student.ports.output.StudentPersistenceInterface
import com.hexagonalkotlin.domain.student.Student
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class StudentPersistenceIntegrationTest : BaseDatabaseIntegrationTest() {

    @Autowired
    lateinit var studentPersistence: StudentPersistenceInterface

    @Test
    fun `should save a student`() {
        val studentToSave = Student("1", "John Doe")
        val savedStudent = studentPersistence.save(studentToSave)

        assertEquals(studentToSave, savedStudent)
    }

    @Test
    fun `should find a student by id`() {
        val studentToSave = Student("1", "John Doe")
        studentPersistence.save(studentToSave)

        val savedFound = studentPersistence.findById("1")

        assertEquals(studentToSave, savedFound)
    }
}