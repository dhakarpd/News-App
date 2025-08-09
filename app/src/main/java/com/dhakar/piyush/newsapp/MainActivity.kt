package com.dhakar.piyush.newsapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dhakar.piyush.newsapp.data.network.RetrofitClient
import com.dhakar.piyush.newsapp.data.repository.NewsApiRepositoryImpl
import com.dhakar.piyush.newsapp.ui.theme.NewsAppTheme
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    LaunchedEffect(key1 = Unit) {

    }

    Button(
        modifier = Modifier.padding(100.dp),
        onClick = {
        runBlocking {
            val news = NewsApiRepositoryImpl(RetrofitClient.apiService)
                .getNewsHeadlinesByCountry(country = "us")
            Log.i("MainActivity","News response - $news")
        }
    }) {
        Text("Hello")
    }


}