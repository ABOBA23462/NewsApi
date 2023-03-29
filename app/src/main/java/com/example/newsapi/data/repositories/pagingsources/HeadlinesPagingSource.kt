package com.example.newsapi.data.repositories.pagingsources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.newsapi.data.remote.apiservice.HeadlinesApiService
import com.example.newsapi.models.HeadlinesModel

private const val HEADLINE_PAGE = 1

class HeadlinePagingSource(private var service: HeadlinesApiService) :
    PagingSource<Int, HeadlinesModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, HeadlinesModel> {
        return try {
            val nextPage = params.key ?: HEADLINE_PAGE
            val response = service.fetchTopHeadlines(nextPage, "q")
            val nextPages = nextPage + 1

            LoadResult.Page(
                data = response.articles,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = nextPages
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, HeadlinesModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}