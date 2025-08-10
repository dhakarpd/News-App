package com.dhakar.piyush.newsapp.data.local

import androidx.room.TypeConverter
import com.dhakar.piyush.newsapp.data.model.NewsSource
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    private val gson = Gson()

    @TypeConverter
    fun fromNewsSource(newsSource: NewsSource): String {
        return gson.toJson(newsSource)
    }

    @TypeConverter
    fun toAddress(newsSourceString: String): NewsSource {
        val type = object : TypeToken<NewsSource>() {}.type
        return gson.fromJson(newsSourceString, type)
    }
}