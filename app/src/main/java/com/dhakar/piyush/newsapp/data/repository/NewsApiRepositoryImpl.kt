package com.dhakar.piyush.newsapp.data.repository

import android.util.Log
import com.dhakar.piyush.newsapp.data.model.NewsSearchRsp
import com.dhakar.piyush.newsapp.data.network.ApiService
import com.dhakar.piyush.newsapp.domain.repository.NewsRepository

class NewsApiRepositoryImpl(val apiService: ApiService): NewsRepository {
    override suspend fun getNewsHeadlinesByCountry(country: String): NewsSearchRsp? {
        var newsSearchResponse: NewsSearchRsp? = null
        try {
            val apiResponse = apiService.getAllTopHeadLineOfSelectedCountry(
                authKey = "",
                country = country,
            )
            if (apiResponse.isSuccessful && apiResponse.body()!= null){
                newsSearchResponse = apiResponse.body()
            }
        } catch (e: Exception){
            Log.e("NewsApiRepositoryImpl","Exception - $e")
        }
        return newsSearchResponse
    }
}