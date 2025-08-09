package com.dhakar.piyush.newsapp.domain.repository

import com.dhakar.piyush.newsapp.data.model.NewsSearchRsp

interface NewsRepository {

    suspend fun getNewsHeadlinesByCountry(country: String): NewsSearchRsp?
}