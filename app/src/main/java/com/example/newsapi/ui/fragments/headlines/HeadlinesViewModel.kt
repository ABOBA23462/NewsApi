package com.example.newsapi.ui.fragments.headlines

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.newsapi.data.repositories.HeadlinesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HeadlinesViewModel @Inject constructor(
    private val headlinesRepository: HeadlinesRepository
) : ViewModel() {

fun fetchHeadlines() = headlinesRepository.getHeadlineList().cachedIn(viewModelScope)
}