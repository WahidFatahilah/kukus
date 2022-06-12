package com.bangkit.kukus.ui.scan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.bangkit.kukus.R
import com.bangkit.kukus.databinding.ActivityScanBinding
import com.bangkit.kukus.databinding.ActivitySplashSuccessBinding
import com.bangkit.kukus.firebase.FirestoreClass
import com.bangkit.kukus.onboarding.ActivityOnboarding
import com.bangkit.kukus.preference.Constant

class SplashSuccessActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashSuccessBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_success)

        binding = ActivitySplashSuccessBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}