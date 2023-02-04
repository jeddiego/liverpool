package com.diegolara.liverpool.usecases.di

import com.diegolara.liverpool.usecases.GetProductsByPageUseCase
import com.diegolara.liverpool.usecases.GetProductsByPageUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object UseCasesModule {
    @Provides
    fun providesGetProductsByPageUseCase(getProductsByPageUseCaseImpl: GetProductsByPageUseCaseImpl): GetProductsByPageUseCase = getProductsByPageUseCaseImpl
}