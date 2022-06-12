package com.bangkit.kukus.ui.drawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bangkit.kukus.R
import com.bangkit.kukus.databinding.ActivityNotificationBinding
import com.bangkit.kukus.databinding.ActivityScanBinding

class Notification : AppCompatActivity() {

    private lateinit var binding: ActivityNotificationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivBack.setOnClickListener {
            onBackPressed()
        }
    }
}