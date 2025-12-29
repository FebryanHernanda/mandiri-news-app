package com.example.mandiri_news_apps.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mandiri_news_apps.R
import com.example.mandiri_news_apps.data.model.Article
import com.example.mandiri_news_apps.helper.formatDate
import org.w3c.dom.Text

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private val items = mutableListOf<Article>()

    fun submit(list: List<Article>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val img: ImageView = itemView.findViewById(R.id.imgNews)
        private val title: TextView = itemView.findViewById(R.id.tvTitle)
        private val source: TextView = itemView.findViewById(R.id.tvSource)
        private val date: TextView = itemView.findViewById(R.id.tvDate)

        fun bind(article: Article) {
            title.text = article.title ?: "-"
            source.text = article.source?.name ?: "-"
            date.text = formatDate.fromIso(article.publishedAt)

            Glide.with(itemView.context)
                .load(article.urlToImage)
                .placeholder(R.drawable.bg_image_placeholder)
                .error(R.drawable.bg_image_placeholder)
                .into(img)
        }
    }

}
