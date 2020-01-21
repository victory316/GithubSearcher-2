package com.example.githubsearcher_2.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GithubUserList {
    @SerializedName("items")
    @Expose
    lateinit var items: List<GithubUserData>

    fun getRepositoryList(): List<GithubUserData> {
        return items
    }
}