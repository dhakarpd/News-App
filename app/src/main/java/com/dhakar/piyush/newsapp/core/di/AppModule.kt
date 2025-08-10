package com.dhakar.piyush.newsapp.core.di

import com.dhakar.piyush.newsapp.data.network.ApiService
import com.dhakar.piyush.newsapp.data.network.RetrofitClient
import com.dhakar.piyush.newsapp.data.repository.NewsApiRepositoryImpl
import com.dhakar.piyush.newsapp.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNetworkRepository(apiService: ApiService): NewsRepository {
        return NewsApiRepositoryImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideNetworkApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofitClient() : Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(RetrofitClient.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}