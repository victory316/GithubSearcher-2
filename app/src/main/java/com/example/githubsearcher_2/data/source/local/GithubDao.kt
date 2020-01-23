package com.example.githubsearcher_2.data.source.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.githubsearcher_2.data.GithubUserData

@Dao
interface GithubDao {

    @Query("SELECT * FROM github_user ORDER BY full_name ASC")
    fun getAll(): LiveData<List<GithubUserData>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(githubData: GithubUserData)

    @Query("DELETE FROM github_user")
    fun deleteAll()
}