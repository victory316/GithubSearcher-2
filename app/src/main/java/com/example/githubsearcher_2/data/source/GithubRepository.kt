package com.example.githubsearcher_2.data.source

import androidx.lifecycle.LiveData
import com.example.githubsearcher_2.data.GithubUserData

class GithubRepository(
    val usersRemoteDataSource: UserDataSource,
    val usersLocalDataSource: UserDataSource
) {
//    private val githubDatabase = GithubDatabase.getInstance(
//        application
//    )!!
//    private val githubDao: GithubDao = githubDatabase.githubDao()
    private val githubData: LiveData<List<GithubUserData>> = githubDao.getAll()

    fun getAll(): LiveData<List<GithubUserData>> {
        return githubData
    }

//    fun insert(githubData: GithubUserData) {
//        try {
//            val thread = Thread(Runnable {
//                githubDao.insert(githubData) })
//            thread.start()
//        } catch (e: Exception) { }
//    }
//
//    fun deleteAll() {
//        try {
//            val thread = Thread(Runnable {
//                githubDao.deleteAll()
//            })
//            thread.start()
//        } catch (e: Exception) { }
//    }

    companion object {

        private var INSTANCE: GithubRepository? = null

        /**
         * Returns the single instance of this class, creating it if necessary.
         * @param tasksRemoteDataSource the backend data source
         * *
         * @param tasksLocalDataSource  the device storage data source
         * *
         * @return the [TasksRepository] instance
         */
        @JvmStatic fun getInstance(tasksRemoteDataSource: UserDataSource,
                                   tasksLocalDataSource: UserDataSource
        ) =
            INSTANCE
                ?: synchronized(GithubRepository::class.java) {
                INSTANCE
                    ?: GithubRepository(
                        tasksRemoteDataSource,
                        tasksLocalDataSource
                    )
                    .also { INSTANCE = it }
            }


        /**
         * Used to force [getInstance] to create a new instance
         * next time it's called.
         */
        @JvmStatic fun destroyInstance() {
            INSTANCE = null
        }
    }
}