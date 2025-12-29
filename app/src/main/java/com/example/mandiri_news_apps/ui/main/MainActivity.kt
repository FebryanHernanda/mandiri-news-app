package com.example.mandiri_news_apps.ui.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mandiri_news_apps.databinding.ActivityMainBinding
import com.example.mandiri_news_apps.helper.formatDate
import com.example.mandiri_news_apps.ui.adapter.NewsAdapter
import com.example.mandiri_news_apps.R


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
        showLoading()
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

            binding.shimmerHeadline.visibility = View.GONE
            binding.headlineCard.visibility = View.VISIBLE

            binding.tvHeadlineTitle.text = article?.title ?: "-"
            binding.tvHeadlineSource.text = article?.source?.name ?: "-"
            binding.tvHeadlineDate.text = formatDate.fromIso(article?.publishedAt)


            Glide.with(this)
                .load(article?.urlToImage)
                .placeholder(R.drawable.bg_image_placeholder)
                .error(R.drawable.bg_image_placeholder)
                .into(binding.imgHeadline)
        }

        viewModel.newsList.observe(this) {
            hideLoading()

            adapter.submit(it)
        }
    }

    private fun showLoading() {
        binding.shimmerHeadline.visibility = View.VISIBLE
        binding.shimmerList.visibility = View.VISIBLE

        binding.headlineCard.visibility = View.GONE
        binding.rvNews.visibility = View.GONE
    }

    private fun hideLoading() {
        binding.shimmerHeadline.visibility = View.GONE
        binding.shimmerList.visibility = View.GONE

        binding.headlineCard.visibility = View.VISIBLE
        binding.rvNews.visibility = View.VISIBLE
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
