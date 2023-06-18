package com.hexagonalkotlin.domain.enums

enum class ErrorCodes(val code: String, val msg: String) {
    HEXK01("HEXK-01", "%s not found!"),
    HEXK02("HEXK-02", "%s invalid!"),
}