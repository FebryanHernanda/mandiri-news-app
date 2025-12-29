package com.example.mandiri_news_apps.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mandiri_news_apps.databinding.ActivityMainBinding
import com.example.mandiri_news_apps.helper.formatDate
import com.example.mandiri_news_apps.ui.adapter.NewsAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        setupRecycler()
        observeData()
        setupInfiniteScroll()
    }

    private fun setupRecycler() {
        adapter = NewsAdapter()
        binding.rvNews.layoutManager = LinearLayoutManager(this)
        binding.rvNews.adapter = adapter
    }

    private fun observeData() {
        viewModel.headline.observe(this) { article ->
            binding.tvHeadlineTitle.text = article?.title ?: "-"
            binding.tvHeadlineSource.text = article?.source?.name ?: "-"
            binding.tvHeadlineDate.text = formatDate.fromIso(article?.publishedAt)


            Glide.with(this)
                .load(article?.urlToImage)
                .into(binding.imgHeadline)
        }

        viewModel.newsList.observe(this) {
            adapter.submit(it)
        }
    }

    private fun setupInfiniteScroll() {
        binding.rvNews.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(rv: RecyclerView, dx: Int, dy: Int) {
                val lm = rv.layoutManager as LinearLayoutManager
                if (lm.findLastVisibleItemPosition() >= lm.itemCount - 2) {
                    viewModel.loadMoreNews()
                }
            }
        })
    }
}
