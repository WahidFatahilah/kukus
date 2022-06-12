package com.bangkit.kukus.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.bangkit.kukus.R
import com.bangkit.kukus.databinding.ActivityMainBinding
import com.bangkit.kukus.ui.scan.ScanActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val navController = findNavController(R.id.fragmentContainerView)
        binding.botttomNavigationView.setupWithNavController(navController)
        binding.botttomNavigationView.background = null

        binding.fab.setOnClickListener { ScanMakanan() }

    }

    private fun ScanMakanan() {
        val intent = Intent(this, ScanActivity::class.java)
        startActivity(intent)
    }
}