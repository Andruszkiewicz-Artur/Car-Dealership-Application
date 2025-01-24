package com.andruszkiewicz.cardealershipapplication.networking.dto

import com.andruszkiewicz.cardealershipapplication.domain.repository.UserModel
import java.time.LocalDateTime

data class UserDto(
    val id: Int,
    val login: String,
    val password_hash: String,
    val email: String,
    val phone: String,
    val first_name: String,
    val last_name: String,
    val created_at: String
) {
    fun toDomain() = UserModel(
        id = id,
        login = login,
        password_hash = password_hash,
        email = email,
        phone = phone,
        first_name = first_name,
        last_name = last_name
    )
}
