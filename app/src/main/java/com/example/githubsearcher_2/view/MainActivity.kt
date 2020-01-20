package com.example.githubsearcher_2.view

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.Observable
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubsearcher_2.R
import com.example.githubsearcher_2.databinding.ActivityMainBinding
import com.example.githubsearcher_2.mock.UserMockHelper
import com.example.githubsearcher_2.view.adapter.UserDataAdapter
import com.example.githubsearcher_2.viewmodel.MainViewModel
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
    private var successDisposable: Disposable? = null
    private var failDisposable: Disposable? = null
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

        githubViewModel.showSuccessToast.addOnPropertyChangedCallback(
            object: Observable.OnPropertyChangedCallback () {
                override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                    Toast.makeText(applicationContext, "Search Success!", Toast.LENGTH_SHORT).show()
                    githubViewModel.showSuccessToast.set(false)
                    hideKeyboard()
                }
        })

        githubViewModel.showFailToast.addOnPropertyChangedCallback(
            object: Observable.OnPropertyChangedCallback () {
                override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                    Toast.makeText(applicationContext, "Search Fail..", Toast.LENGTH_SHORT).show()
                    githubViewModel.showFailToast.set(false)
                    hideKeyboard()
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
