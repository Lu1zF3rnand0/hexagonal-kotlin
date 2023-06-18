package com.hexagonalkotlin.adapter.web.advice

import com.hexagonalkotlin.adapter.web.response.ErrorResponse
import com.hexagonalkotlin.domain.student.exceptions.InvalidStudentException
import com.hexagonalkotlin.domain.student.exceptions.StudentNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class ControllerAdvice {

    @ExceptionHandler(StudentNotFoundException::class)
    fun handleStudentNotFoundException(
            ex: StudentNotFoundException,
            request: WebRequest
    ): ResponseEntity<ErrorResponse> {
        val error = ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                ex.message!!,
                ex.errorCode,
                null
        )
        return ResponseEntity(error, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(InvalidStudentException::class)
    fun handleInvalidStudentException(
            ex: InvalidStudentException,
            request: WebRequest
    ): ResponseEntity<ErrorResponse> {
        val error = ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                ex.message!!,
                ex.errorCode,
                null
        )
        return ResponseEntity(error, HttpStatus.BAD_REQUEST)
    }
}