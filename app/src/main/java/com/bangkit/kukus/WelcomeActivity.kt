package com.bangkit.kukus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bangkit.kukus.onboarding.ActivityOnboarding

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
    }

    fun StartOnboarding(view: View) {
        startActivity(Intent(this@WelcomeActivity, ActivityOnboarding::class.java))
    }

}