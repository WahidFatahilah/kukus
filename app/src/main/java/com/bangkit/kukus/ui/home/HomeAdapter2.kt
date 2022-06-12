package com.bangkit.kukus.ui.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.kukus.databinding.RvListHealthyFoodRecBinding
import com.bangkit.kukus.helper.DummyRvHome
import com.bumptech.glide.Glide

class HomeAdapter2 : RecyclerView.Adapter<HomeAdapter2.HomeViewHolder>() {

    var onItemClick: ((DummyRvHome.Dummy2) -> Unit)? = null
    private val listData = ArrayList<DummyRvHome.Dummy2>()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: List<DummyRvHome.Dummy2>) {
        listData.clear()
        listData.addAll(list)
        notifyDataSetChanged()
    }

    inner class HomeViewHolder(private val binding: RvListHealthyFoodRecBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: DummyRvHome.Dummy2) {
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
            RvListHealthyFoodRecBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int = listData.size
}