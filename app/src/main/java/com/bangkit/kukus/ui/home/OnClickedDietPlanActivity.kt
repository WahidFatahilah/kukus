package com.bangkit.kukus.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.kukus.databinding.ActivityOnClickedDietPlanBinding
import com.bangkit.kukus.helper.DummyRvHome
import com.bumptech.glide.Glide

class OnClickedDietPlanActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnClickedDietPlanBinding
    private lateinit var recMakananAdapter: DietAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnClickedDietPlanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<DummyRvHome.Dummy1>(EXTRA_DATA)

        binding.apply {
            Glide.with(ivTittleResepMakanan)
                .load(data?.img)
                .into(ivTittleResepMakanan)
            tvTittleDiet.text = data?.nama
            tvBodyDiet.text = data?.description
            tvBodyDos.text = data?.dos
            tvBodyDonts.text = data?.donts
        }

        binding.ivBackDiet.setOnClickListener {
            onBackPressed()
        }

        recMakananAdapter = DietAdapter()
        recMakananAdapter.setData(DummyRvHome.generateDataRvDiet())
        binding.rvRekomendasiMakanan.adapter = recMakananAdapter

    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}