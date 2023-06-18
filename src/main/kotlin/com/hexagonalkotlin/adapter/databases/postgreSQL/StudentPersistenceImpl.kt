package com.hexagonalkotlin.adapter.databases.postgreSQL

import com.hexagonalkotlin.domain.student.ports.output.StudentPersistenceInterface
import com.hexagonalkotlin.domain.student.Student
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class StudentPersistenceImpl(
        private val studentRepository: StudentRepository
): StudentPersistenceInterface {
    override fun save(student: Student): Student {
        return studentRepository.save(student.toModel()).toStudent()
    }

    override fun findById(id: String): Student? {
        return studentRepository.findByIdOrNull(id)?.toStudent()
    }
}