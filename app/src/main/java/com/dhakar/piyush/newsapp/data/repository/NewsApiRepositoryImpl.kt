package com.dhakar.piyush.newsapp.data.repository

import android.util.Log
import com.dhakar.piyush.newsapp.data.local.NewsDao
import com.dhakar.piyush.newsapp.data.model.NewsSearchRsp
import com.dhakar.piyush.newsapp.data.network.ApiService
import com.dhakar.piyush.newsapp.domain.repository.NewsRepository

class NewsApiRepositoryImpl(val apiService: ApiService, val newsDao: NewsDao): NewsRepository {
    override suspend fun getNewsHeadlinesByCountry(country: String): NewsSearchRsp? {
        var newsSearchResponse: NewsSearchRsp? = null
        try {
            val apiResponse = apiService.getAllTopHeadLineOfSelectedCountry(
                authKey = "",
                country = country,
            )
            if (apiResponse.isSuccessful && apiResponse.body()!= null){
                newsSearchResponse = apiResponse.body()
                newsSearchResponse?.let { saveDataToDb(it) }
            }
        } catch (e: Exception){
            Log.e("NewsApiRepositoryImpl","Exception - $e")
        }
        return newsSearchResponse
    }

    private suspend fun saveDataToDb(newsSearchResponse: NewsSearchRsp) {
        for (article in newsSearchResponse.articles) {
            if (article.urlToImage != null) {
                newsDao.insertNews(article)
            }
        }
    }
}