package com.andruszkiewicz.cardealershipapplication.networking

import com.andruszkiewicz.cardealershipapplication.domain.mode.CarModel

data class CarDto(
    val id: Int,
    val brand: String,
    val model: String,
    val price: String,
    val body_type: String,
    val power: Int,
    val transmission: String,
    val color: String,
    val production_year: Int,
    val description: String,
    val details: String
) {
    fun toDomain() = CarModel(
        id = id,
        brand = brand,
        model = model,
        price = price,
        body_type = body_type,
        power = power,
        transmission = transmission,
        color = color,
        production_year = production_year,
        description = description
    )
}
