package com.bangkit.kukus.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.kukus.databinding.ActivityOnClickArticleBinding
import com.bangkit.kukus.helper.DummyRvHome
import com.bangkit.kukus.helper.DummyRvHome.generateDataDummy4
import com.bumptech.glide.Glide

class OnClickArticleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnClickArticleBinding
    private lateinit var recArticleAdapter: ArticleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnClickArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getIntExtra(EXTRA_POSITION, 0)

        val content = generateDataDummy4().get(data)
        Glide.with(this@OnClickArticleActivity)
            .load(content.img)
            .into(binding.ivImgArticle)
        binding.tvTittleArticle.text = content.nama
        binding.tvBodyArticle.text = content.description


        binding.ivBackArticle.setOnClickListener {
            onBackPressed()
        }

        recArticleAdapter = ArticleAdapter()
        recArticleAdapter.setData(DummyRvHome.generateDataRvArticle())
        binding.rvArticle.adapter = recArticleAdapter
    }

    companion object {
        const val EXTRA_POSITION = "extra_position"
    }
}