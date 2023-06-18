package com.hexagonalkotlin.adapter.web.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.hexagonalkotlin.adapter.web.BaseWebIntegrationTest
import com.hexagonalkotlin.adapter.web.response.StudentResponse
import com.hexagonalkotlin.domain.student.Student
import com.hexagonalkotlin.domain.student.ports.output.StudentPersistenceInterface
import com.hexagonalkotlin.templates.StudentRequestsTemplate
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class StudentControllerIntegrationTest : BaseWebIntegrationTest() {

    companion object {
        const val BASE_URL = "/api/v1/students"
    }

    @Autowired
    lateinit var studentPersistence: StudentPersistenceInterface

    private val objectMapper = ObjectMapper()

    @Test
    fun `should save a student`() {
        val body = StudentRequestsTemplate.buildCreateRequest()

        val result = mvc.perform(
                post(BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body)
        )
                .andExpect(status().isCreated)
                .andReturn()

        val studentResponse = objectMapper.readValue(result.response.contentAsString, StudentResponse::class.java)
        assertEquals("John Doe", studentResponse.name)

        val savedStudent = studentPersistence.findById(studentResponse.id)
        assertEquals(studentResponse.id, savedStudent?.id)
    }

    @Test
    fun `should find a student by id`() {
        val studentToSave = Student("1", "John Doe")
        studentPersistence.save(studentToSave)

        mvc.perform(
                get("$BASE_URL/${studentToSave.id}")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk)
                .andExpect(jsonPath("id", `is`(studentToSave.id)))
    }
}