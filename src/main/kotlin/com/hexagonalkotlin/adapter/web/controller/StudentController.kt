package com.hexagonalkotlin.adapter.web.controller

import com.hexagonalkotlin.adapter.web.request.CreateStudentRequest
import com.hexagonalkotlin.adapter.web.response.StudentResponse
import com.hexagonalkotlin.adapter.web.response.toStudentResponse
import com.hexagonalkotlin.domain.student.ports.input.CreateStudentUseCaseInterface
import com.hexagonalkotlin.domain.student.ports.input.FindStudentByIdUseCaseInterface
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class StudentController(
        private val createStudentUseCase: CreateStudentUseCaseInterface,
        private val findStudentByIdUseCase: FindStudentByIdUseCaseInterface
) {

    @PostMapping("/v1/students")
    fun create(@RequestBody request: CreateStudentRequest): ResponseEntity<StudentResponse> {
        val student = createStudentUseCase.save(request.toStudent()).toStudentResponse()
        return ResponseEntity.status(HttpStatus.CREATED).body(student)
    }

    @GetMapping("/v1/students/{id}")
    fun findById(@PathVariable id: String): ResponseEntity<StudentResponse> {
        val student = findStudentByIdUseCase.findById(id).toStudentResponse()
        return ResponseEntity.ok(student)
    }
}