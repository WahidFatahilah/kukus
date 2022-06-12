package com.bangkit.kukus.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.kukus.databinding.ActivityOnClickedHealthyFoodBinding
import com.bangkit.kukus.helper.DummyRvHome
import com.bumptech.glide.Glide

class OnClickedHealthyFoodActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnClickedHealthyFoodBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnClickedHealthyFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<DummyRvHome.Dummy2>(EXTRA_DATA)

        binding.apply {
            Glide.with(ivTittleResepMakanan)
                .load(data?.img)
                .into(ivTittleResepMakanan)
            Glide.with(ivKandunganGizi)
                .load(data?.gizi)
                .into(ivKandunganGizi)
            tvTittleResepMakanan.text = data?.nama
            tvBodyBahanBahan.text = data?.bahan
            tvBodyCaraPembuatan.text = data?.resep
        }

        binding.ivBackFood.setOnClickListener {
            onBackPressed()
        }
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}