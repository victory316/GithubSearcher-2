package com.example.githubsearcher_2.data.source

import com.example.githubsearcher_2.data.GithubUserData

interface UserDataSource {

    interface LoadTasksCallback {

        fun onTasksLoaded(tasks: List<GithubUserData>)

        fun onDataNotAvailable()
    }

    interface GetTaskCallback {

        fun onTaskLoaded(task: GithubUserData)

        fun onDataNotAvailable()
    }

    fun getTasks(callback: LoadTasksCallback)

    fun getTask(taskId: String, callback: GetTaskCallback)

    fun saveTask(task: GithubUserData)

    fun completeTask(task: GithubUserData)

    fun completeTask(taskId: String)

    fun activateTask(task: GithubUserData)

    fun activateTask(taskId: String)

    fun clearCompletedTasks()

    fun refreshTasks()

    fun deleteAllTasks()

    fun deleteTask(taskId: String)
}