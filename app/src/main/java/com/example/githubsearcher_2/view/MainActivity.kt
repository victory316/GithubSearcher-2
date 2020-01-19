package com.example.githubsearcher_2.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.githubsearcher_2.R

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
