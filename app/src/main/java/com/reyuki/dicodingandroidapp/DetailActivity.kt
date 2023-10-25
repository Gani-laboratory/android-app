package com.reyuki.dicodingandroidapp

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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
        binding.tvItemContent.text = data.content
        binding.imgItemPhoto.setImageResource(data.coverPhoto)
        binding.btnShare.setOnClickListener {
            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, data.title + "\n" + data.content)
                type = "text/plain"
            }
            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }
    }
}