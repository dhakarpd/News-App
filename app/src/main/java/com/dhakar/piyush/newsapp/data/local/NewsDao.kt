package com.dhakar.piyush.newsapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dhakar.piyush.newsapp.data.model.Article

@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNews(article: Article)

    @Query("SELECT * from news_articles")
    suspend fun getAllNews() : List<Article>
}