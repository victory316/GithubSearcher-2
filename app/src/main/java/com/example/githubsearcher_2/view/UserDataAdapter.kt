package com.example.githubsearcher_2.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.githubsearcher_2.R
import com.example.githubsearcher_2.data.GithubUserData
import com.example.githubsearcher_2.databinding.GithubItemBinding

class UserDataAdapter(private val userData: List<GithubUserData>) : RecyclerView.Adapter<UserDataAdapter.BindingHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingHolder {
        val bind = DataBindingUtil.inflate<GithubItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.github_item, parent, false)

        return BindingHolder(
            bind
        )
    }

    override fun onBindViewHolder(holder: BindingHolder, position: Int) {
//        val binding = holder.binding
//        holder.bind
//        holder.binding.viewModel = MainViewModel(userData[position])
    }

    override fun getItemCount(): Int {
        return userData.size
    }

    class BindingHolder(val bind: GithubItemBinding) : RecyclerView.ViewHolder(bind.userDataItem)
}