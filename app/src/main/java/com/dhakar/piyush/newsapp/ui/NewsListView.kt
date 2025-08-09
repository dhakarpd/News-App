package com.dhakar.piyush.newsapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dhakar.piyush.newsapp.data.model.Article

@Composable
fun NewsListView(articles: ArrayList<Article>) {
    LazyColumn(
        modifier = Modifier.background(Color.White),
        contentPadding = PaddingValues(horizontal = 4.dp, vertical = 4.dp)
    ) {
        items(articles){ article ->
            NewsListItemView(article)
        }
    }
}