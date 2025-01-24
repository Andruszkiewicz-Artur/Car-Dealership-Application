package com.andruszkiewicz.cardealershipapplication.domain.repository

import com.andruszkiewicz.cardealershipapplication.domain.mode.CarModel
import com.andruszkiewicz.cardealershipapplication.domain.mode.UserModel

interface CarDealershipRepository {

    suspend fun getCars(): List<CarModel>

    suspend fun getCar(id: Int): CarModel?

    suspend fun getUsers(): List<UserModel>

    suspend fun createUser(user: UserModel): Boolean
}