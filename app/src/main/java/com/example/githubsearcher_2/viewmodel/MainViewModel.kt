package com.example.githubsearcher_2.viewmodel

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.githubsearcher_2.BR
import com.example.githubsearcher_2.data.GithubUserData

class MainViewModel(private val mUser: GithubUserData): BaseObservable() {
    fun doSearch() {
//        githubView.doSearch()
    }

    var full_name: String?
        @Bindable
        get() = mUser.full_name
        set(title) {
            mUser.full_name = title!!
            notifyPropertyChanged(BR.fullName)
        }

    var descriptions: String?
        @Bindable
        get() = mUser.description
        set(subtitle) {
            mUser.description = subtitle!!
            notifyPropertyChanged(BR.descriptions)
        }
}