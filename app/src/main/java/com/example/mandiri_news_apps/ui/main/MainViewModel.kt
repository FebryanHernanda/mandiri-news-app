package com.example.mandiri_news_apps.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mandiri_news_apps.data.model.Article
import com.example.mandiri_news_apps.data.repository.NewsRepository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val repository = NewsRepository()

    val headline = MutableLiveData<Article?>()
    val newsList = MutableLiveData<List<Article>>()

    private val allNews = mutableListOf<Article>()
    private var page = 1

    init {
        loadHeadline()
        loadMoreNews()
    }

    private fun loadHeadline() {
        viewModelScope.launch {
            try {
                headline.value =
                    repository.getHeadlines().articles.firstOrNull()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun loadMoreNews() {
        viewModelScope.launch {
            try {
                val response = repository.getAllNews(page)
                allNews.addAll(response.articles)
                newsList.value = allNews
                page++
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
