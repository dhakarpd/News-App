package com.dhakar.piyush.newsapp.data.repository

import com.dhakar.piyush.newsapp.data.local.NewsDao
import com.dhakar.piyush.newsapp.data.network.ApiService
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class NewsApiRepositoryImplTest {

    // ?? How does mock know about it's impl. How does it make the instances?
    @Mock
    lateinit var apiService: ApiService

    @Mock
    lateinit var newsDao: NewsDao

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @After
    fun tearDown() {

    }

    @Test
    fun getNewsHeadlinesByCountry_forEmptyCountry_returnNull() {
        runBlocking{
            //Mockito.`when`(apiService.getAllTopHeadLineOfSelectedCountry("","")).then(null)

            whenever(apiService.getAllTopHeadLineOfSelectedCountry("",""))
                .thenReturn(null)
            val newsRepo = NewsApiRepositoryImpl(apiService, newsDao)
            val headlines = newsRepo.getNewsHeadlinesByCountry("")
            assertEquals(null,headlines)

        }
    }

}