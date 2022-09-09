package com.example.exam7.di

import com.example.exam7.common.constants.ApiEndPoints
import com.example.exam7.remote.ApiService
import com.example.exam7.repository.DataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun apiService(): ApiService = Retrofit.Builder()
        .baseUrl(ApiEndPoints.BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(ApiService::class.java)

    @Singleton
    @Provides
    fun provideLoginRepository(api: ApiService): DataRepository = DataRepository(api)

}