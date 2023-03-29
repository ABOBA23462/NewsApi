package com.example.newsapi.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapi.base.BaseDiffUtilItemCallback
import com.example.newsapi.databinding.ItemHeadlinesBinding
import com.example.newsapi.extension.setImage
import com.example.newsapi.models.HeadlinesModel

class HeadlinesAdapter : PagingDataAdapter<HeadlinesModel, HeadlinesAdapter.ViewHolder>(
    BaseDiffUtilItemCallback()
) {

    class ViewHolder(private val binding: ItemHeadlinesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: HeadlinesModel?) = with(binding) {
            title.text = item?.title
            desc.text = item?.description
            source.text = item?.source.toString()
            author.text = item?.author
            publishedAt.text = item?.publishAt
            img.setImage(item!!.urlToImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemHeadlinesBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }
}