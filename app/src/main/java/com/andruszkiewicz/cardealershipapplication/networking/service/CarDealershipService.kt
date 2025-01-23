package com.andruszkiewicz.cardealershipapplication.networking.service

import com.andruszkiewicz.cardealershipapplication.networking.CarDto
import retrofit2.Response
import retrofit2.http.GET

interface CarDealershipService {

    @GET("cars")
    suspend fun getCars(): Response<List<CarDto>>

}