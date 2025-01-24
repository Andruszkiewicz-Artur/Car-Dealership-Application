package com.andruszkiewicz.cardealershipapplication.networking.dto

data class UserRequest(
    val id: Int,
    val login: String,
    val password_hash: String,
    val email: String,
    val phone: String,
    val first_name: String,
    val last_name: String,
    val create_at: String,
)
