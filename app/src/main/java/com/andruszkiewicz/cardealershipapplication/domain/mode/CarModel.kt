package com.andruszkiewicz.cardealershipapplication.domain.mode

data class CarModel (
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
    val imagesUrl: List<String>
)