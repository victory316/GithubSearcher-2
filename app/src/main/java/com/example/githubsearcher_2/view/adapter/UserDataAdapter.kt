package com.example.githubsearcher_2.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.githubsearcher_2.R
import com.example.githubsearcher_2.data.GithubUserData
import com.example.githubsearcher_2.databinding.GithubItemBinding
import com.example.githubsearcher_2.viewmodel.MainViewModel

class UserDataAdapter(private val userData: List<GithubUserData>) : RecyclerView.Adapter<UserDataAdapter.BindingHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingHolder {
        val binding = DataBindingUtil.inflate<GithubItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.github_item, parent, false)

        return BindingHolder(binding)
    }

    override fun onBindViewHolder(holder: BindingHolder, position: Int) {
        val binding = holder.binding
        binding.viewModel = MainViewModel(userData[position])
    }

    override fun getItemCount(): Int {
        return userData.size
    }

    class BindingHolder(val binding: GithubItemBinding) : RecyclerView.ViewHolder(binding.userDataItem)
}