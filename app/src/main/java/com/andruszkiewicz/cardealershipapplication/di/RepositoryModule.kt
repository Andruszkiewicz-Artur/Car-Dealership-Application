package com.andruszkiewicz.cardealershipapplication.di

import com.andruszkiewicz.cardealershipapplication.domain.repository.CarDealershipRepository
import com.andruszkiewicz.cardealershipapplication.networking.repository.CarDealershipRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCarDealershipRepository(repository: CarDealershipRepositoryImpl): CarDealershipRepository

}