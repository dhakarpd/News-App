package com.dhakar.piyush.newsapp.core.di

import android.content.Context
import androidx.room.Room
import com.dhakar.piyush.newsapp.data.local.AppDatabase
import com.dhakar.piyush.newsapp.data.local.NewsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideNewsDao(appDatabase: AppDatabase) : NewsDao {
        return appDatabase.newsDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context) : AppDatabase {
        return Room
            .databaseBuilder(context, AppDatabase::class.java, "news_database")
            .fallbackToDestructiveMigration()
            .build()
    }
}