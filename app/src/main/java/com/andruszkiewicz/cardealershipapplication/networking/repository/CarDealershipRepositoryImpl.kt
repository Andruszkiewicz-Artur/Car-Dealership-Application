package com.andruszkiewicz.cardealershipapplication.networking.repository

import com.andruszkiewicz.cardealershipapplication.domain.mode.CarModel
import com.andruszkiewicz.cardealershipapplication.domain.repository.CarDealershipRepository
import com.andruszkiewicz.cardealershipapplication.networking.service.CarDealershipService
import timber.log.Timber
import javax.inject.Inject

class CarDealershipRepositoryImpl @Inject constructor(
    private val carDealershipService: CarDealershipService
): CarDealershipRepository {

    override suspend fun getCars(): List<CarModel> =
        try {
            carDealershipService
                .getCars()
                .body()
                ?.map { it.toDomain() }
                ?: emptyList()
        } catch (e: Exception) {
            Timber.e("error: %s", e.message)
            emptyList()
        }

    override suspend fun getCar(id: Int): CarModel? =
        try {
            carDealershipService
                .getCar(id)
                .body()
                ?.toDomain()
        } catch (e: Exception) {
            Timber.e("error: %s", e.message)
            null
        }
}