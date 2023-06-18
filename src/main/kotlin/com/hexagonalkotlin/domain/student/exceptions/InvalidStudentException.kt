package com.hexagonalkotlin.domain.student.exceptions

class InvalidStudentException(msg: String, val errorCode: String) : RuntimeException(msg)
