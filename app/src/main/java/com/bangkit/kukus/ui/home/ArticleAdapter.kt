package com.bangkit.kukus.ui.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.kukus.databinding.RvArticleBinding
import com.bangkit.kukus.helper.DummyRvHome
import com.bumptech.glide.Glide

class ArticleAdapter : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {

    private val listData = ArrayList<DummyRvHome.DummyRvArticle>()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: List<DummyRvHome.DummyRvArticle>){
        listData.clear()
        listData.addAll(list)
        notifyDataSetChanged()
    }

    class ArticleViewHolder(private val binding: RvArticleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: DummyRvHome.DummyRvArticle){
            binding.apply {
                Glide.with(imgArticle)
                    .load(data.img)
                    .into(imgArticle)
                tvRvArticle.text = data.nama
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val binding = RvArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int = listData.size
}