package com.andruszkiewicz.cardealershipapplication.domain.mode

import com.andruszkiewicz.cardealershipapplication.networking.dto.UserDto
import com.andruszkiewicz.cardealershipapplication.networking.dto.UserRequest
import java.time.LocalDateTime

data class UserModel(
    val id: Int = 0,
    val login: String,
    val password_hash: String,
    val email: String,
    val phone: String,
    val first_name: String,
    val last_name: String
) {
    fun toDto() = UserRequest(
        id = id,
        login = login,
        password_hash = password_hash,
        email = email,
        phone = phone,
        first_name = first_name,
        last_name = last_name,
        create_at = "2023-11-23T19:30:00"
    )
}
