package com.example.clean_architecture_android.core.common

object ValidationUtil {

    fun validateName(name: String): String? {
        return when {
            name.isBlank() -> "Name cannot be empty"
            name.length < 3 -> "Name must be at least 3 characters"
            !name.all { it.isLetter() || it.isWhitespace() } -> "Name can only contain letters and spaces"
            else -> null
        }
    }

    fun validateEmail(email: String): String? {
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$".toRegex()
        return when {
            email.isBlank() -> "Email cannot be empty"
            !email.matches(emailRegex) -> "Enter a valid email address"
            else -> null
        }
    }

    fun validatePassword(password: String): String? {
        return when {
            password.isBlank() -> "Name cannot be empty"
            password.length < 3 -> "Name must be at least 3 characters"
            !password.all { it.isLetter() || it.isWhitespace() } -> "Name can only contain letters and spaces"
            else -> null
        }
    }
}

