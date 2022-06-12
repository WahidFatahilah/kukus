package com.bangkit.kukus.ui.drawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bangkit.kukus.R
import com.bangkit.kukus.databinding.ActivitySettingBinding

class SettingActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.ivBack.setOnClickListener { onBackPressed() }
    }
}