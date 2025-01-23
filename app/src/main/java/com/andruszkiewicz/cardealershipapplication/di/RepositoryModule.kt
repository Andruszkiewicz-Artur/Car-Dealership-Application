package com.andruszkiewicz.cardealershipapplication.di

import com.andruszkiewicz.cardealershipapplication.domain.repository.CarDealershipRepository
import com.andruszkiewicz.cardealershipapplication.networking.repository.CarDealershipRepositoryImpl
import com.andruszkiewicz.cardealershipapplication.networking.service.CarDealershipService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun bindCarDealershipRepository(service: CarDealershipService): CarDealershipRepository =
        CarDealershipRepositoryImpl(service)

}