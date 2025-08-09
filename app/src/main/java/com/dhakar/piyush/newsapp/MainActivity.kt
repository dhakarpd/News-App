package com.dhakar.piyush.newsapp

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dhakar.piyush.newsapp.ui.NewsListView
import com.dhakar.piyush.newsapp.ui.theme.NewsAppTheme
import com.dhakar.piyush.newsapp.ui.viewmodel.NewsViewmodel
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // TODO: Check the status bar color setting
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(scrim = Color.WHITE, darkScrim = Color.WHITE)
        )
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
fun Greeting(
    name: String,
    modifier: Modifier = Modifier,
    newsViewmodel: NewsViewmodel = viewModel()) {

    val context = LocalContext.current

    LaunchedEffect(key1 = Unit) {
        delay(1000)
        newsViewmodel.getNewsHeadlinesOfCountry(context = context, country = "us")
    }

    Column(modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        if (newsViewmodel.newsFetchStatus.value != "") {
            Text(newsViewmodel.newsFetchStatus.value)
        } else {
            NewsListView(newsViewmodel.newsData)
        }


    }

}