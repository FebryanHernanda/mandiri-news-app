package com.example.mandiri_news_apps.data.repository

import com.example.mandiri_news_apps.network.RetrofitInstance
import com.example.mandiri_news_apps.BuildConfig

class NewsRepository {

    suspend fun getHeadlines() =
        RetrofitInstance.api.getHeadlines(apiKey = BuildConfig.NEWS_API_KEY)

    suspend fun getAllNews(page: Int) =
        RetrofitInstance.api.getAllNews(page = page, apiKey = BuildConfig.NEWS_API_KEY)
}
