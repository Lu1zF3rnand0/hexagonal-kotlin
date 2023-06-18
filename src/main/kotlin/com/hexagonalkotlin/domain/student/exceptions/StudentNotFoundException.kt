package com.hexagonalkotlin.domain.student.exceptions

class StudentNotFoundException(msg: String, val errorCode: String) : RuntimeException(msg)