package com.dhakar.piyush.newsapp.data.repository

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.dhakar.piyush.newsapp.data.local.AppDatabase
import com.dhakar.piyush.newsapp.data.local.NewsDao
import com.dhakar.piyush.newsapp.data.network.ApiService
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class NewsApiRepositoryImplTest {
    lateinit var newsDatabase: AppDatabase
    lateinit var newsDao: NewsDao

    @Mock
    lateinit var apiService: ApiService

    @Before
    fun setUp() {

        // Why inMemoryDatabaseBuilder?
        // Why allowMainThreadQueries
        // Why not simulated as if real code scenario
        newsDatabase = Room
            .inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(), AppDatabase::class.java)
            .allowMainThreadQueries()
            .build()

        newsDao = newsDatabase.newsDao()

        MockitoAnnotations.initMocks(this)

    }

    @Test
    fun getNewsHeadlinesByCountry_forEmptyCountry_returnNull() = runTest{
        Mockito.`when`(apiService.getAllTopHeadLineOfSelectedCountry("","")).then(null)

        val newsRepo = NewsApiRepositoryImpl(apiService, newsDao)
        val headlines = newsRepo.getNewsHeadlinesByCountry("")
        assertEquals(null,headlines)

    }

    @After
    fun tearDown() {

    }



}