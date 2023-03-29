package com.example.newsapi.data.remote.apiservice

import com.example.newsapi.models.NewsResponse
import com.example.newsapi.models.HeadlinesModel
import retrofit2.http.GET
import retrofit2.http.Query

interface HeadlinesApiService {
    @GET("https://newsapi.org/v2/top-headlines?country=us&apiKey=c0704ded67a8428a983315901ed4607b")
    suspend fun fetchTopHeadlines(
        @Query("page") page: Int,
        @Query("q") query: String
    ): NewsResponse<HeadlinesModel>
}