package com.example.newsapi.di

import com.example.newsapi.data.remote.RetrofitClient
import com.example.newsapi.data.remote.apiservice.HeadlinesApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Singleton
    val retrofitClient: RetrofitClient = RetrofitClient()

    @Singleton
    @Provides
    fun provideTopHeadlinesApiService(): HeadlinesApiService {
        return retrofitClient.provideTopHeadlinesApiService()
    }
}