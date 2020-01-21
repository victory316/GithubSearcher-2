package com.example.githubsearcher_2.viewmodel

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.databinding.library.baseAdapters.BR
import com.example.githubsearcher_2.data.GithubUserData
import com.example.githubsearcher_2.mock.UserMockHelper
import com.example.githubsearcher_2.remote.GithubClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val userData: GithubUserData): BaseObservable() {
    var currentInput = ObservableField<String> ()
    var showSuccessToast = ObservableBoolean()
    var showFailToast = ObservableBoolean()

    fun doSearch() {

        // Gihub search query로 찾고자 하는 유저를 검색
        val searchDisposable = GithubClient().getApi().searchUser(currentInput.get()!!)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ result ->

                UserMockHelper.actualGithubData.clear()
                UserMockHelper.actualGithubData.addAll(result.getRepositoryList())

                // 검색결과가 없을 경우의 예외처리 및 피드백
                if (result.getRepositoryList().isEmpty()) {
                    UserMockHelper.actualGithubData.clear()
                    showFailToast.set(true)
                } else {
                    showSuccessToast.set(true)
                }

                currentInput.set("")

            }, {
                    error ->
                run {
                    UserMockHelper.actualGithubData.clear()

                    // 검색중 오류가 발생했을 경우의 예외처리 및 피드백
                    error.printStackTrace()

                    currentInput.set("")
                    showFailToast.set(true)
                }
            })
    }

    var login: String
        @Bindable
        get() = userData.login
        set(full_name) {
            notifyPropertyChanged(BR.login)
        }

    var score: String?
        @Bindable
        get() = userData.score.toString()
        set(description) {
            notifyPropertyChanged(BR.score)
        }
}