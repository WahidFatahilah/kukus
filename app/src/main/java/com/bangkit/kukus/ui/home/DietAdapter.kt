package com.bangkit.kukus.ui.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.kukus.databinding.RvListOnClickDietPlanRecBinding
import com.bangkit.kukus.helper.DummyRvHome
import com.bumptech.glide.Glide

class DietAdapter : RecyclerView.Adapter<DietAdapter.DietViewHolder>() {

    private val listData = ArrayList<DummyRvHome.DummyRvDiet>()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: List<DummyRvHome.DummyRvDiet>) {
        listData.clear()
        listData.addAll(list)
        notifyDataSetChanged()
    }

    inner class DietViewHolder(private val binding: RvListOnClickDietPlanRecBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: DummyRvHome.DummyRvDiet){
            binding.apply {
                Glide.with(ivImageRV)
                    .load(data.img)
                    .into(ivImageRV)
                tvTittleRV.text = data.nama
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DietViewHolder {
        val binding = RvListOnClickDietPlanRecBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DietViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DietViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int = listData.size
}