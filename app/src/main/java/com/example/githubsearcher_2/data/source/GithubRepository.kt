package com.example.githubsearcher_2.data.source

import androidx.lifecycle.LiveData
import com.example.githubsearcher_2.data.GithubUserData

class GithubRepository(
    val usersRemoteDataSource: UserDataSource,
    val usersLocalDataSource: UserDataSource
) : UserDataSource{

//    private val githubDatabase = GithubDatabase.getInstance(
//        application
//    )!!
//    private val githubDao: GithubDao = githubDatabase.githubDao()
//    private val githubData: LiveData<List<GithubUserData>> = githubDao.getAll()

//    fun getAll(): LiveData<List<GithubUserData>> {
////        return githubData
//    }

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


//    for (indices in userList) {
//
//        // 데이터가 없을 경우를 대비한 기본값 설정
//        var fullName = ""
//        var descriptions = "Not described"
//        var stargazersCount = 0
//        var language = "Not described"
//
//        // 공란이 있을 수 있는 자료들에 한해 null check, null일 경우에는 default 값을 적용
//        if (indices.description != null) descriptions = indices.description
//        if (indices.stargazers_count != null) stargazersCount = indices.stargazers_count
//        if (indices.language != null) language = indices.language
//
//        val githubData = GithubUserData(indices.full_name, descriptions, stargazersCount, language)
////            repository.insert(githubData)
//    }

    override fun addUserList() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun insertList(userList: List<GithubUserData>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getList(): LiveData<List<GithubUserData>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

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