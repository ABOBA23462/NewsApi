package com.example.newsapi.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.newsapi.data.remote.apiservice.HeadlinesApiService
import com.example.newsapi.data.repositories.pagingsources.HeadlinePagingSource
import com.example.newsapi.models.HeadlinesModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HeadlinesRepository @Inject constructor(
    private val headlinesApiService: HeadlinesApiService
) {
    fun getHeadlineList(): Flow<PagingData<HeadlinesModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                HeadlinePagingSource(headlinesApiService)
            }
        ).flow
    }
}