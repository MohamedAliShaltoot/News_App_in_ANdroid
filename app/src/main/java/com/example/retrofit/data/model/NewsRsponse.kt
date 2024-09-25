package com.example.retrofit.data.model

import com.google.gson.annotations.SerializedName

data class NewsRsponse(
   val articles: List<Article>,
    val status: String,
   val totalResults: Int
)