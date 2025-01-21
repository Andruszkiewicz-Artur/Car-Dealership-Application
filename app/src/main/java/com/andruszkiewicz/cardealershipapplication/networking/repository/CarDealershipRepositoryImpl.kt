package com.andruszkiewicz.cardealershipapplication.networking.repository

import com.andruszkiewicz.cardealershipapplication.domain.repository.CarDealershipRepository
import com.andruszkiewicz.cardealershipapplication.networking.service.CarDealershipService
import javax.inject.Inject

class CarDealershipRepositoryImpl @Inject constructor(
    private val carDealershipService: CarDealershipService
): CarDealershipRepository {



}