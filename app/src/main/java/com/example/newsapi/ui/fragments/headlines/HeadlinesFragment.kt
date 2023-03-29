package com.example.newsapi.ui.fragments.headlines

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.newsapi.R
import com.example.newsapi.base.BaseFragment
import com.example.newsapi.databinding.FragmentHeadlinesBinding
import com.example.newsapi.ui.adapter.HeadlinesAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HeadlinesFragment :
    BaseFragment<FragmentHeadlinesBinding, HeadlinesViewModel>(R.layout.fragment_headlines) {

    override val binding by viewBinding(FragmentHeadlinesBinding::bind)
    override val viewModel: HeadlinesViewModel by viewModels()
    private val headlinesAdapter = HeadlinesAdapter()

    override fun initialize() {
        binding.rvTopHeadlines.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = headlinesAdapter
        }
    }

    override fun setupCollect() {
        lifecycleScope.launch {
            viewModel.fetchHeadlines().collect {
                headlinesAdapter.submitData(it)
            }
        }
    }
}