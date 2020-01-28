/*
 * Copyright 2017, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.githubsearcher_2.util

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData

import com.example.githubsearcher_2.data.GithubUserData
import com.example.githubsearcher_2.data.source.UserDataSource
import java.util.LinkedHashMap

/**
 * Implementation of a remote data source with static access to the data for easy testing.
 */
object FakeTasksRemoteDataSource : UserDataSource {

    override fun insertList(userList: List<GithubUserData>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getList(): LiveData<List<GithubUserData>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
