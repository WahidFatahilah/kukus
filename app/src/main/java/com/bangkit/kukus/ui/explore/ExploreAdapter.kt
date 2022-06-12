package com.bangkit.kukus.ui.explore

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.kukus.data.remote.response.explore.ExploreResponseFinalItem
import com.bangkit.kukus.data.remote.response.explore.ExploreResponseItem
import com.bangkit.kukus.databinding.RvListExploreBinding
import com.bumptech.glide.Glide

class ExploreAdapter : RecyclerView.Adapter<ExploreAdapter.HomeViewHolder>() {

    private var listUsers = ArrayList<ExploreResponseFinalItem>()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(users: List<ExploreResponseFinalItem>?) {
        if (users == null) return
        this.listUsers.clear()
        this.listUsers.addAll(users)
        notifyDataSetChanged()
    }

    inner class HomeViewHolder(private val binding: RvListExploreBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: ExploreResponseFinalItem) {
            binding.apply {
                Glide.with(itemView.context)
                    .load(data.feeds)
                    .into(imgPostingan)
                Glide.with(itemView.context)
                    .load(data.userAvatar)
                    .into(imgPictureProfile)
                tvUsernameProfile.text = data.username
                tvTotalLikes.text = data.numLikes
                tvContentPostingan.text = data.caption
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