package com.hexagonalkotlin.domain.student

data class Student(var id: String? = null, var name: String) {
    fun isValid(): Boolean {
        return name.isNotBlank()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Student

        if (id != other.id) return false
        return name == other.name
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + name.hashCode()
        return result
    }

    override fun toString(): String {
        return "Student(id=$id, name='$name')"
    }

}