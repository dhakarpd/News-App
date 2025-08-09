package com.dhakar.piyush.newsapp.ui.viewmodel

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dhakar.piyush.newsapp.data.model.Article
import com.dhakar.piyush.newsapp.data.network.RetrofitClient
import com.dhakar.piyush.newsapp.data.repository.NewsApiRepositoryImpl
import com.dhakar.piyush.newsapp.util.InternetConnectivityChecker
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsViewmodel(): ViewModel() {

    /**
     *      Possible values
     *          Fetching
     *          No Internet Available
     *          Error Fetching Data
     *          Fetched
     * **/

    val newsFetchStatus = mutableStateOf("")

    var newsData : ArrayList<Article> = arrayListOf()

    fun getNewsHeadlinesOfCountry(context: Context, country: String) {
        viewModelScope.launch(Dispatchers.IO) {
            newsFetchStatus.value = "Fetching"

            if(InternetConnectivityChecker.isConnectedToInternet(context = context)) {
                val newsRsp = NewsApiRepositoryImpl(RetrofitClient.apiService)
                    .getNewsHeadlinesByCountry(country = country)

                newsFetchStatus.value = newsRsp?.let {
                    newsData = it.articles
                    ""
                } ?: run {
                    "Error Fetching Data"
                }

            } else {
                newsFetchStatus.value = "No Internet Available"
            }
        }
    }
}