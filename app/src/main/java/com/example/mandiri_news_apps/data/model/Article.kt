package com.example.mandiri_news_apps.data.model

data class Source(
    val name: String?
)

data class Article(
    val title : String?,
    val description: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val source: Source?
)