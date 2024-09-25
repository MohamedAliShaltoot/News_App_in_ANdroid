package com.example.retrofit

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import coil.compose.AsyncImage
import com.example.retrofit.ui.theme.RetrofitTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

val viewModel= remember { MAinViewModel() }

            viewModel.getNews()
            val news =viewModel.newsResponse.collectAsState()
            RetrofitTheme {
Column(modifier = Modifier
    .fillMaxSize()
    .padding(16.dp)) {
    Log.v("news","${ news.value}")
    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        items(news.value?.articles?: emptyList()){
            Card(modifier = Modifier.fillMaxSize().padding(16.dp)) {
                Column(modifier = Modifier.fillMaxSize().padding(16.dp))  {
                    Text(text = it.author?:"")
                    Text(text = it.title?:"")
                    Text(text = it.description?:"")
                   AsyncImage(model = it.urlToImage?:"", contentDescription =null )
                }
            }
        }
    }
//    Text(news.value?.status?:"")
}
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RetrofitTheme {
        Greeting("Android")
    }
}