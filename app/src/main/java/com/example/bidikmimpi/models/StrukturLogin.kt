package com.example.bidikmimpi.models

data class StrukturLogin(
    val email: String,
    val password: String
)

data class RegisterLogin(
    val email: String,
    val password: String,
    val confirm_password: String,
    val name: String
)