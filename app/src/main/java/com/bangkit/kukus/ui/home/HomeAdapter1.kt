package com.bangkit.kukus.ui.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.kukus.databinding.RvListDietPlanRecBinding
import com.bangkit.kukus.helper.DummyRvHome
import com.bumptech.glide.Glide

class HomeAdapter1 : RecyclerView.Adapter<HomeAdapter1.HomeViewHolder>() {

    var onItemClick: ((DummyRvHome.Dummy1) -> Unit)? = null
    private val listData = ArrayList<DummyRvHome.Dummy1>()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: List<DummyRvHome.Dummy1>) {
        listData.clear()
        listData.addAll(list)
        notifyDataSetChanged()
    }

    inner class HomeViewHolder(private val binding: RvListDietPlanRecBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: DummyRvHome.Dummy1) {
            binding.apply {
                Glide.with(circleImageView)
                    .load(data.img)
                    .into(circleImageView)
                textView.text = data.nama
            }
            itemView.setOnClickListener {
                onItemClick?.invoke(data)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding =
            RvListDietPlanRecBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int = listData.size
}