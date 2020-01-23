package com.example.githubsearcher_2.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.githubsearcher_2.data.source.GithubRepository

class ViewModelFactory(
    private val githubRepository: GithubRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(githubRepository) as T
    }
}