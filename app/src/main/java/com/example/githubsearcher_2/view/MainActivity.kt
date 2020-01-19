package com.example.githubsearcher_2.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.githubsearcher_2.R
import com.example.githubsearcher_2.databinding.ActivityMainBinding

/**
 *
 *  Github User Searcher
 *
 *  MVVM with no AAC
 *
 *  by CSH
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }
}
