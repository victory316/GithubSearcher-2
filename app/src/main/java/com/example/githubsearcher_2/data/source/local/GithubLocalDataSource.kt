package com.example.githubsearcher_2.data.source.local

import android.service.autofill.UserData
import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import com.example.githubsearcher_2.data.GithubUserData
import com.example.githubsearcher_2.data.source.UserDataSource
import com.example.githubsearcher_2.util.AppExecutors

class TasksLocalDataSource private constructor(
    val appExecutors: AppExecutors,
    val tasksDao: GithubDao
) : UserDataSource {

    /**
     * Note: [LoadTasksCallback.onDataNotAvailable] is fired if the database doesn't exist
     * or the table is empty.
     */
//    override fun getTasks(callback: TasksDataSource.LoadTasksCallback) {
//        appExecutors.diskIO.execute {
//            val tasks = tasksDao.getTasks()
//            appExecutors.mainThread.execute {
//                if (tasks.isEmpty()) {
//                    // This will be called if the table is new or just empty.
//                    callback.onDataNotAvailable()
//                } else {
//                    callback.onTasksLoaded(tasks)
//                }
//            }
//        }
//    }
//
//    /**
//     * Note: [GetTaskCallback.onDataNotAvailable] is fired if the [Task] isn't
//     * found.
//     */
//    override fun getTask(taskId: String, callback: TasksDataSource.GetTaskCallback) {
//        appExecutors.diskIO.execute {
//            val task = tasksDao.getTaskById(taskId)
//            appExecutors.mainThread.execute {
//                if (task != null) {
//                    callback.onTaskLoaded(task)
//                } else {
//                    callback.onDataNotAvailable()
//                }
//            }
//        }
//    }
//
//    override fun saveTask(task: Task) {
//        appExecutors.diskIO.execute { tasksDao.insertTask(task) }
//    }
//
//    override fun completeTask(task: Task) {
//        appExecutors.diskIO.execute { tasksDao.updateCompleted(task.id, true) }
//    }
//
//    override fun completeTask(taskId: String) {
//        // Not required for the local data source because the {@link TasksRepository} handles
//        // converting from a {@code taskId} to a {@link task} using its cached data.
//    }
//
//    override fun activateTask(task: Task) {
//        appExecutors.diskIO.execute { tasksDao.updateCompleted(task.id, false) }
//    }
//
//    override fun activateTask(taskId: String) {
//        // Not required for the local data source because the {@link TasksRepository} handles
//        // converting from a {@code taskId} to a {@link task} using its cached data.
//    }
//
//    override fun clearCompletedTasks() {
//        appExecutors.diskIO.execute { tasksDao.deleteCompletedTasks() }
//    }
//
//    override fun refreshTasks() {
//        // Not required because the {@link TasksRepository} handles the logic of refreshing the
//        // tasks from all the available data sources.
//    }
//
//    override fun deleteAllTasks() {
//        appExecutors.diskIO.execute { tasksDao.deleteTasks() }
//    }
//
//    override fun deleteTask(taskId: String) {
//        appExecutors.diskIO.execute { tasksDao.deleteTaskById(taskId) }
//    }
//

    override fun insertList(userList: List<GithubUserData>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getList(): LiveData<List<GithubUserData>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        private var INSTANCE: TasksLocalDataSource? = null

        @JvmStatic
        fun getInstance(appExecutors: AppExecutors, tasksDao: GithubDao): TasksLocalDataSource {
            if (INSTANCE == null) {
                synchronized(TasksLocalDataSource::javaClass) {
                    INSTANCE = TasksLocalDataSource(appExecutors, tasksDao)
                }
            }
            return INSTANCE!!
        }

        @VisibleForTesting
        fun clearInstance() {
            INSTANCE = null
        }
    }
}
