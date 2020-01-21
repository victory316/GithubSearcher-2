package com.example.githubsearcher_2.data

import com.google.gson.annotations.SerializedName

data class GithubUserData(
    @SerializedName("login") val login: String,
    @SerializedName("score") val score: Double
)