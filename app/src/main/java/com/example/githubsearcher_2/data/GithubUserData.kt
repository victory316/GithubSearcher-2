package com.example.githubsearcher_2.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName= "github_user")
data class GithubUserData(
    @PrimaryKey(autoGenerate = false)
    @SerializedName("full_name") val full_name: String,
    @SerializedName("description") val description: String?,
    @SerializedName("stargazers_count") val stargazers_count: Int?,
    @SerializedName("language") val language: String?
)