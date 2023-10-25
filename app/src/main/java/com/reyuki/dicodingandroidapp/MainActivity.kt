package com.reyuki.dicodingandroidapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.reyuki.dicodingandroidapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var rvArticles: RecyclerView
    private val list = ArrayList<Article>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.profile -> {
                val intentToDetail = Intent(this@MainActivity, ProfileActivity::class.java)
                startActivity(intentToDetail)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvArticles = binding.rvArticles
        rvArticles.setHasFixedSize(true)
        list.addAll(getListArticle())
        showRecyclerList()
    }

    private fun getListArticle(): ArrayList<Article> {
        val listArticle = ArrayList<Article>()
        val dataTitle = resources.getStringArray(R.array.data_title)
        val dataContent = resources.getStringArray(R.array.data_content)
        val dataPhoto = resources.obtainTypedArray(R.array.data_cover)
        for (i in dataTitle.indices) {
            val article = Article(dataTitle[i], dataContent[i], dataPhoto.getResourceId(i, -1))
            listArticle.add(article)
        }
        dataPhoto.recycle()

        return listArticle
    }

    private fun showRecyclerList() {
        rvArticles.layoutManager = LinearLayoutManager(this)
        val listArticleAdapter = ListArticleAdapter(list)
        rvArticles.adapter = listArticleAdapter

    }
}