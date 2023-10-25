package com.reyuki.dicodingandroidapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.reyuki.dicodingandroidapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val data = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Article>("data", Article::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Article>("data")
        }

        binding.tvItemTitle.text = data!!.title
        binding.tvItemContent.text = data!!.content
        binding.imgItemPhoto.setImageResource(data!!.coverPhoto)
    }
}