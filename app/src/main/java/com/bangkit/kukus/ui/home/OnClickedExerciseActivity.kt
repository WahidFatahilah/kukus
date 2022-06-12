package com.bangkit.kukus.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.kukus.databinding.ActivityOnClickedExerciseBinding
import com.bangkit.kukus.helper.DummyRvHome
import com.bumptech.glide.Glide
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem

class OnClickedExerciseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnClickedExerciseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnClickedExerciseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<DummyRvHome.Dummy3>(EXTRA_DATA)

        binding.apply {
            Glide.with(ivTittleClickExercise)
                .load(data?.img)
                .into(ivTittleClickExercise)
            tvTittleClickExercise.text = data?.nama
            tvBodyKalori.text = data?.kalori
            tvBodyDurasi.text = data?.durasi
            tvBodyAlat.text = data?.alat
            tvBodyPersiapan.text = data?.persiapan

            val player = ExoPlayer.Builder(this@OnClickedExerciseActivity).build()
            videoView.player = player

            val mediaItem = data?.let { MediaItem.fromUri(it.video) }
            if (mediaItem != null) {
                player.setMediaItem(mediaItem)
            }
            player.prepare()

        }

        binding.ivBackExercise.setOnClickListener {
            onBackPressed()
        }
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}