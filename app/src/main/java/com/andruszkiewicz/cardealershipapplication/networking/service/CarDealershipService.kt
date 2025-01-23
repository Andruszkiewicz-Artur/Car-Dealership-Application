package com.andruszkiewicz.cardealershipapplication.networking.service

import com.andruszkiewicz.cardealershipapplication.networking.CarDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CarDealershipService {

    @GET("cars")
    suspend fun getCars(): Response<List<CarDto>>

    @GET("cars/{id}")
    suspend fun getCar(@Path("id") id: Int): Response<CarDto>

}