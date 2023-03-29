package com.example.newsapi.models

import com.example.newsapi.base.IBaseDiffModel
import com.google.gson.annotations.SerializedName

data class HeadlinesModel(
    @SerializedName("source")
    val source: Source,

    @SerializedName("author")
    val author: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("url")
    override val url: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("urlToImage")
    val urlToImage: String,

    @SerializedName("publishAt")
    val publishAt: String,

    @SerializedName("content")
    val content: String,
) : IBaseDiffModel