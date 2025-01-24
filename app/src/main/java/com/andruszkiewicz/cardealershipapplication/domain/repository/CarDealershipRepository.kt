package com.andruszkiewicz.cardealershipapplication.domain.repository

import com.andruszkiewicz.cardealershipapplication.domain.mode.CarModel

interface CarDealershipRepository {

    suspend fun getCars(): List<CarModel>

    suspend fun getCar(id: Int): CarModel?

    suspend fun getUsers(): List<UserModel>
}