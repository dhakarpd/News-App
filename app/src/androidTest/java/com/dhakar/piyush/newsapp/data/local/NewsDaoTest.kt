package com.dhakar.piyush.newsapp.data.local

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.dhakar.piyush.newsapp.data.model.Article
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class NewsDaoTest {

    lateinit var newsDatabase: AppDatabase
    lateinit var newsDao: NewsDao

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
    }

    @Test
    fun insertNews_ExpectedSingleResult() = runBlocking{
        newsDao.insertNews(Article(author = "Piyush", title = "Mumbai Rains", description = "Rainy season"))

        val data = newsDao.getAllNews()
        Assert.assertEquals(1, data.size)
        Assert.assertEquals("Piyush", data[0].author)
    }

    @After
    fun tearDown() {
        newsDatabase.close()
    }
}