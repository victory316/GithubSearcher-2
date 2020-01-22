package com.example.githubsearcher_2.mock

import com.example.githubsearcher_2.data.GithubUserData

object UserMockHelper {

    val mockArticleData: List<GithubUserData>
        get() {
            val list = ArrayList<GithubUserData>()
            for (i in 0..24) {
                val article = GithubUserData("example", "",0, "")

                list.add(article)
            }
            return list
        }

    val actualGithubData = ArrayList<GithubUserData>()
}