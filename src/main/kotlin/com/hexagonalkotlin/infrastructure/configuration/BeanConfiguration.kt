package com.hexagonalkotlin.infrastructure.configuration

import com.hexagonalkotlin.domain.student.ports.input.CreateStudentUseCaseInterface
import com.hexagonalkotlin.domain.student.ports.input.FindStudentByIdUseCaseInterface
import com.hexagonalkotlin.domain.student.ports.output.StudentPersistenceInterface
import com.hexagonalkotlin.domain.student.usecase.CreateStudentUseCaseImpl
import com.hexagonalkotlin.domain.student.usecase.FindStudentByIdUseCaseImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeanConfiguration {

    @Bean
    fun findStudentByIdUseCase(studentPersistence: StudentPersistenceInterface): FindStudentByIdUseCaseInterface {
        return FindStudentByIdUseCaseImpl(studentPersistence)
    }

    @Bean
    fun createStudentUseCase(studentPersistence: StudentPersistenceInterface): CreateStudentUseCaseInterface {
        return CreateStudentUseCaseImpl(studentPersistence)
    }
}