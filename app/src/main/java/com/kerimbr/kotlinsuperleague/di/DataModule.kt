package com.kerimbr.kotlinsuperleague.di

import com.kerimbr.kotlinsuperleague.data.DataRepository
import com.kerimbr.kotlinsuperleague.data.DataRepositoryImpl
import com.kerimbr.kotlinsuperleague.data.remote.data_source.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideDataRepository(
        remoteDataSource: RemoteDataSource
    ): DataRepository = DataRepositoryImpl(remoteDataSource)



}