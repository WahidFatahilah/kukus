package com.bangkit.kukus.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bangkit.kukus.ui.home.MainActivity
import com.bangkit.kukus.databinding.LoginBinding

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding : LoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginBinding.inflate(layoutInflater);
        setContentView(binding.root)

        binding.tvLoginHighlined.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {

    }

    fun Login(view: View) {
        val intent = Intent(this@LoginActivity, MainActivity::class.java)
        startActivity(intent)
    }
}