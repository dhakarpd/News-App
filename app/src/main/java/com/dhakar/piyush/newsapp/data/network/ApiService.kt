package com.dhakar.piyush.newsapp.data.network

import com.dhakar.piyush.newsapp.data.model.NewsSearchRsp
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {

    @Headers("Accept: application/json")
    @GET("v2/top-headlines")
    suspend fun getAllTopHeadLineOfSelectedCountry(
        // TODO: Add below header via interceptor
        @Header("X-Api-Key") authKey: String,
        @Query("country") country: String,
    ): Response<NewsSearchRsp?>
}