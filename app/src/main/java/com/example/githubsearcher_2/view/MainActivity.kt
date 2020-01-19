package com.example.githubsearcher_2.view

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubsearcher_2.R
import com.example.githubsearcher_2.databinding.ActivityMainBinding
import com.example.githubsearcher_2.mock.UserMockHelper
import com.example.githubsearcher_2.remote.GithubClient
import com.example.githubsearcher_2.view.adapter.UserDataAdapter
import com.example.githubsearcher_2.viewmodel.MainViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 *
 *  Github User Searcher
 *
 *  MVVM with no AAC  |  by CSH
 *
 *
 *  Reference
 *
 *  - https://github.com/irontec/android-mvvm-example
 *
 *  - https://github.com/android/architecture-samples/tree/todo-mvvm-databinding
 *
 */

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var searchDisposable: Disposable? = null
    private lateinit var githubViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val layoutManager = LinearLayoutManager(this)
        val articles = UserMockHelper.mockArticleData
        val adapter = UserDataAdapter(articles)

        githubViewModel = MainViewModel()

        binding.viewModel = githubViewModel

        binding.searchRecyclerView.layoutManager = layoutManager
        binding.searchRecyclerView.adapter = adapter
    }

    fun doSearch() {

        // 검색 이후 키보드를 숨김
        hideKeyboard()

        val target = binding.searchEditText.text.toString()

        // Gihub search query로 찾고자 하는 유저를 검색
        searchDisposable = GithubClient().getApi().searchUser(target)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ result ->
                githubViewModel.insertList(result.getRepositoryList())

                // 검색결과가 없을 경우의 예외처리 및 피드백
                if (result.getRepositoryList().isEmpty()) {
                    Toast.makeText(this, "결과가 존재하지 않습니다.", Toast.LENGTH_SHORT).show()
                }

            }, {
                    error ->
                run {
                    // 검색중 오류가 발생했을 경우의 예외처리 및 피드백
                    error.printStackTrace()
                    Toast.makeText(this, "검색중 오류가 발생했습니다.", Toast.LENGTH_SHORT).show()
                }
            })
    }

    private fun Context.hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun Activity.hideKeyboard() {
        if (currentFocus == null) View(this) else currentFocus?.let { hideKeyboard(it) }
    }
}
