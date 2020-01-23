package com.example.githubsearcher_2.viewmodel

import androidx.databinding.BaseObservable
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import com.example.githubsearcher_2.mock.UserMockHelper
import com.example.githubsearcher_2.data.source.local.remote.GithubClient
import com.example.githubsearcher_2.data.source.GithubRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val githubRepository: GithubRepository): BaseObservable() {
    var currentInput = ObservableField<String> ()
    var showSuccessToast = ObservableBoolean()
    var showFailToast = ObservableBoolean()

    fun doSearch() {

        // Gihub search query로 찾고자 하는 유저를 검색
        val searchDisposable = GithubClient()
            .getApi().searchUser(currentInput.get()!!)
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

//    var full_name: String
//        @Bindable
//        get() = githubRepository.full_name
//        set(full_name) {
//            notifyPropertyChanged(BR.full_name)
//        }
//
//    var description: String?
//        @Bindable
//        get() = githubRepository.description.toString()
//        set(description) {
//            notifyPropertyChanged(BR.description)
//        }
//
//    var stargazers_count: String?
//        @Bindable
//        get() = githubRepository.stargazers_count.toString()
//        set(description) {
//            notifyPropertyChanged(BR.stargazers_count)
//        }
//
//    var language: String?
//        @Bindable
//        get() = githubRepository.language.toString()
//        set(description) {
//            notifyPropertyChanged(BR.language)
//        }
}