package com.hexagonalkotlin.adapter.web.response

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ErrorResponse(
        var httpCode: Int,
        var message: String,
        var internalCode: String,
        var errors: List<FieldErrorResponse>?
) {
    data class FieldErrorResponse(
            var field: String,
            var message: String
    )
}
