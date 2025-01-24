package com.andruszkiewicz.cardealershipapplication.domain.repository

import com.andruszkiewicz.cardealershipapplication.networking.dto.UserDto
import java.time.LocalDateTime

data class UserModel(
    val id: Int,
    val login: String,
    val password_hash: String,
    val email: String,
    val phone: String,
    val first_name: String,
    val last_name: String
) {
    fun toDto() = UserDto(
        id = id,
        login = login,
        password_hash = password_hash,
        email = email,
        phone = phone,
        first_name = first_name,
        last_name = last_name,
        created_at = LocalDateTime.now().toString()
    )
}
