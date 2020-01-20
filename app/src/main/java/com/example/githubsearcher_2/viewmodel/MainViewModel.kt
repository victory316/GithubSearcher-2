package com.example.githubsearcher_2.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.databinding.library.baseAdapters.BR
import com.example.githubsearcher_2.data.GithubUserData
import com.example.githubsearcher_2.remote.GithubClient
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel(): BaseObservable() {
    var currentInput = ObservableField<String> ()
    var showSuccessToast = ObservableBoolean()
    var showFailToast = ObservableBoolean()

    fun showSuccessToast(): Observable<Boolean> {
        return Observable.just(true)
    }

    fun doSearch() {
//        val target = binding.searchEditText.text.toString()

        Log.d("viewTest", "doSearch() : ${currentInput.get()}")

        // Gihub search query로 찾고자 하는 유저를 검색
        val searchDisposable = GithubClient().getApi().searchUser(currentInput.get()!!)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ result ->
//                githubViewModel.insertList(result.getRepositoryList())

                // 검색결과가 없을 경우의 예외처리 및 피드백
                if (result.getRepositoryList().isEmpty()) {

                    Log.d("viewTest", "input fail : ${currentInput.get()}")

                    currentInput.set("")
                    showFailToast.set(true)

                } else {
                    Log.d("viewTest", "input success : ${currentInput.get()}")
                    showSuccessToast.set(true)

                    currentInput.set("")
                }

            }, {
                    error ->
                run {
                    // 검색중 오류가 발생했을 경우의 예외처리 및 피드백
                    error.printStackTrace()

                    Log.d("viewTest", "input fail : ${currentInput.get()}")

                    currentInput.set("")
                    showFailToast.set(true)
                }
            })
    }

    fun insertList(contactList: List<GithubUserData>) {

        if (!contactList.isNullOrEmpty()) {
            for (indices in contactList) {

                Log.d("insertTest", "contacts : $indices")
            }
        }
    }

//    var full_name: String?
//        @Bindable
//        get() = mUser.full_name
//        set(title) {
//            mUser.full_name = title!!
//            notifyPropertyChanged(BR.full_name)
//        }
//
//    var descriptions: String?
//        @Bindable
//        get() = mUser.description
//        set(subtitle) {
//            mUser.description = subtitle!!
//            notifyPropertyChanged(BR.descriptions)
//        }
}