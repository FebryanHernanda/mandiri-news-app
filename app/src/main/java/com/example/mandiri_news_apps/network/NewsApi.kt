package com.example.mandiri_news_apps.network

import com.example.mandiri_news_apps.data.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("v2/top-headlines")
    suspend fun getHeadlines(
        @Query("country") country: String = "us",
        @Query("apiKey") apiKey: String
    ): NewsResponse

    @GET("v2/everything")
    suspend fun getAllNews(
        @Query("q") query: String = "technology",
        @Query("page") page: Int,
        @Query("apiKey") apiKey: String
    ): NewsResponse
}
