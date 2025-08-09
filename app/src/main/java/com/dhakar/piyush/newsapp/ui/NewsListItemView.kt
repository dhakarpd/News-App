package com.dhakar.piyush.newsapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.dhakar.piyush.newsapp.data.model.Article

@Composable
fun NewsListItemView(article: Article) {
    Card(modifier = Modifier.fillMaxWidth().height(150.dp).padding(horizontal = 0.dp, vertical = 4.dp)) {
        Row {
            AsyncImage(
                model = article.urlToImage,
                contentDescription = article.title,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .weight(0.4f)
                    .padding(horizontal = 4.dp, vertical = 4.dp)
                    .clip(RoundedCornerShape(8.dp))
            )

            Column(modifier = Modifier.weight(0.6f).padding(4.dp), verticalArrangement = Arrangement.SpaceEvenly) {
                Text(maxLines = 1, text = article.title?: "", fontWeight = FontWeight.Bold)
                Text(maxLines = 3, text = article.description?: "")
            }
        }
    }
}