package com.bangkit.kukus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bangkit.kukus.ui.login.LoginActivity

class OnboardingIntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)
    }

    fun Start(view: View) {
        val intent = Intent(this@OnboardingIntroActivity, LoginActivity::class.java)
        startActivity(intent)
    }

}