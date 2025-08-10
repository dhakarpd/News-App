package com.dhakar.piyush.newsapp.core

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NewsApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.i("NewsApp", "OnCreate")
    }
}