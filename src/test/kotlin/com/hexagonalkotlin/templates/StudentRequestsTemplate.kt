package com.hexagonalkotlin.templates

class StudentRequestsTemplate {
    companion object {
        fun buildCreateRequest(): String {
            return """
                {
                    "name": "John Doe"
                }
            """.trimIndent()
        }
    }
}