package com.dhakar.piyush.newsapp.ui.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


/**
 * A way of passing a parameter to viewmodel when not using dependency injection
 *
 * while creating instance of viewmodel in composable below is the code to follow
 *
 * fun MyScreen(userId: String) {
 *
 *     val viewModel: MyViewModel = viewModel(
 *         factory = MyViewModelFactory(userId)
 *     )
 *
 *     val data by viewModel.data.observeAsState("")
 *     Text(text = data)
 * }
 *
 * viewModel() call will not create a new ViewModel on every recomposition.
 *
 * **/
class NewsViewmodelProviderFactory(val context: Context): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewsViewmodel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return NewsViewmodel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}