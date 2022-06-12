package com.bangkit.kukus

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.kukus.databinding.ActivitySplashBinding
import com.bangkit.kukus.firebase.FirestoreClass
import com.bangkit.kukus.onboarding.ActivityOnboarding
import com.bangkit.kukus.preference.Constant
import com.bangkit.kukus.preference.Utils
import com.bangkit.kukus.ui.home.MainActivity
import com.bangkit.kukus.ui.login.LoginActivity

class SplashActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val currentUserID = FirestoreClass().getCurrentUserID()
        var kaloriHarian = Utils.getPreferenceInt(this@SplashActivity, Constant.KALORI_HARIAN)
        if (kaloriHarian==0){
        }

        Handler(Looper.getMainLooper()).postDelayed({

            var kaloriHarian = Utils.getPreferenceInt(this@SplashActivity, Constant.KALORI_HARIAN)

            if (kaloriHarian==0) {
                startActivity(Intent(this@SplashActivity, WelcomeActivity::class.java))
            } else {
                if (currentUserID.isNotEmpty()) {

                    startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                } else {

                    startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
                }
            }
            finish()
        }, 1000)

    }

}