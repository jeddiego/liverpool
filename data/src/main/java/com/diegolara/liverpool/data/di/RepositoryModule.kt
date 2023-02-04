package com.diegolara.liverpool.data.di

import com.diegolara.liverpool.data.RemoteDataSource
import com.diegolara.liverpool.data.RemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {
    @Provides
    fun providesNetworkDataSource(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource = remoteDataSourceImpl
}