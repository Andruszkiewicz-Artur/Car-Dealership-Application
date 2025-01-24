package com.andruszkiewicz.cardealershipapplication.networking.service

import com.andruszkiewicz.cardealershipapplication.networking.dto.CarDto
import com.andruszkiewicz.cardealershipapplication.networking.dto.UserDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CarDealershipService {

    @GET("cars")
    suspend fun getCars(): Response<List<CarDto>>

    @GET("cars/{id}")
    suspend fun getCar(@Path("id") id: Int): Response<CarDto>

    @GET("users")
    suspend fun getUsers(): Response<List<UserDto>>

}