package com.diegolara.liverpool.data.di

import com.diegolara.liverpool.data.ProductServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServicesModule {
    @Singleton
    @Provides
    fun provideMoviesService(retrofit: Retrofit): ProductServices =
        retrofit.create(ProductServices::class.java)
}