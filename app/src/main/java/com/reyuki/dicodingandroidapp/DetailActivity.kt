package com.reyuki.dicodingandroidapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val data = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Article>("data", Article::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Article>("data")
        }

        Log.d("TEST", data!!.title)
    }
}