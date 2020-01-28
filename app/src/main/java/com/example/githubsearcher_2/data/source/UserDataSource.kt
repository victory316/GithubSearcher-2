package com.example.githubsearcher_2.data.source

import androidx.lifecycle.LiveData
import com.example.githubsearcher_2.data.GithubUserData

interface UserDataSource {

    interface LoadTasksCallback {

        fun onUserLoaded(tasks: List<GithubUserData>)

        fun onDataNotAvailable()
    }

    interface GetTaskCallback {

        fun onUserLoaded(task: GithubUserData)

        fun onDataNotAvailable()
    }

    fun addUserList()

    fun insertList(userList: List<GithubUserData>)

    fun getList(): LiveData<List<GithubUserData>>

}