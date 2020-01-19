package com.example.githubsearcher_2.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableField
import androidx.databinding.library.baseAdapters.BR
import com.example.githubsearcher_2.data.GithubUserData
import com.example.githubsearcher_2.remote.GithubClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel(): BaseObservable() {
    var currentInput = ObservableField<String> ()

    fun doSearch() {
//        githubView.doSearch()

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
//                    Toast.makeText(this, "결과가 존재하지 않습니다.", Toast.LENGTH_SHORT).show()
                }

                Log.d("viewTest", "input success : ${currentInput.get()}")

                currentInput.set("")

            }, {
                    error ->
                run {
                    // 검색중 오류가 발생했을 경우의 예외처리 및 피드백
                    error.printStackTrace()

                    Log.d("viewTest", "input fail : ${currentInput.get()}")

                    currentInput.set("")

//                    Toast.makeText(this, "검색중 오류가 발생했습니다.", Toast.LENGTH_SHORT).show()
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