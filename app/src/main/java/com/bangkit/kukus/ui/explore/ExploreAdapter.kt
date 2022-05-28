package com.bangkit.kukus.ui.explore

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.kukus.data.remote.response.explore.ExploreResponseItem
import com.bangkit.kukus.databinding.RvListExploreBinding
import com.bumptech.glide.Glide

class ExploreAdapter : RecyclerView.Adapter<ExploreAdapter.HomeViewHolder>() {

    private var listUsers = ArrayList<ExploreResponseItem>()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(users: List<ExploreResponseItem>?) {
        if (users == null) return
        this.listUsers.clear()
        this.listUsers.addAll(users)
        notifyDataSetChanged()
    }

    inner class HomeViewHolder(private val binding: RvListExploreBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: ExploreResponseItem) {
            binding.apply {
                Glide.with(itemView.context)
                    .load(data.avatar_url)
                    .into(imgPostingan)
                Glide.with(itemView.context)
                    .load(data.avatar_url)
                    .into(imgPictureProfile)
                tvUsernameProfile.text = data.login
                tvTotalLikes.text = data.id.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding =
            RvListExploreBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(listUsers[position])
    }

    override fun getItemCount(): Int = listUsers.size
}