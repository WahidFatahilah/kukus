package com.bangkit.kukus.onboarding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.kukus.R
import com.bangkit.kukus.databinding.ActivityMainBinding
import com.bangkit.kukus.databinding.ActivityOnboardingBinding

class ActivityOnboarding : AppCompatActivity() {

    lateinit var binding: ActivityOnboardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}