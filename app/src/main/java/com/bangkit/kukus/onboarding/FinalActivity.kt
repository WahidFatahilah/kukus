package com.bangkit.kukus.onboarding

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.kukus.databinding.ActivityFinalBinding
import com.bangkit.kukus.preference.Constant
import com.bangkit.kukus.preference.Utils
import com.bangkit.kukus.ui.login.LoginActivity

class FinalActivity : AppCompatActivity() {

    lateinit var binding: ActivityFinalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            var kaloriHarianFinal: Int
            var goal = Utils.getPreferenceInt(this@FinalActivity, Constant.TUJUAN_IDEAL)
            var kelamin = Utils.getPreferenceInt(this@FinalActivity, Constant.JENIS_KELAMIN)
            var umur = Utils.getPreferenceInt(this@FinalActivity, Constant.UMUR)
            var tinggiBadan = Utils.getPreferenceInt(this@FinalActivity, Constant.TINGGI_BADAN)
            var beratBadan = Utils.getPreferenceInt(this@FinalActivity, Constant.BERAT_BADAN)
            var aktivitas = Utils.getPreferenceFloat(this@FinalActivity, Constant.TINGKAT_AKTIVITAS)
            var lamaProses = Utils.getPreferenceFloat(this@FinalActivity, Constant.KECEPATAN_PROSES)

            var BMR = (10 * beratBadan) + (6.25 * tinggiBadan) - (5 * umur) + kelamin
            tvBodyBMR.text = BMR.toInt().toString()
            var TDEE = BMR * aktivitas
            tvBodyTDEE.text = TDEE.toInt().toString()
            var cutting = lamaProses * TDEE
            tvBodyRange.text = cutting.toInt().toString()

            if (goal == 0) {
                var kaloriHarian = TDEE + cutting
                kaloriHarianFinal = kaloriHarian.toInt()
                tvBodyKaloriHarian.text = kaloriHarian.toInt().toString()
                Utils.putPreferenceInt(
                    this@FinalActivity,
                    Constant.KALORI_HARIAN,
                    kaloriHarianFinal
                )
            } else {
                var kaloriHarian = TDEE - cutting
                kaloriHarianFinal = kaloriHarian.toInt()
                tvBodyKaloriHarian.text = kaloriHarian.toInt().toString()
                Utils.putPreferenceInt(
                    this@FinalActivity,
                    Constant.KALORI_HARIAN,
                    kaloriHarianFinal
                )
            }
            btnSelesai.setOnClickListener {
                val intent = Intent(this@FinalActivity, LoginActivity::class.java)
                startActivity(intent)
            }
        }
    }
}