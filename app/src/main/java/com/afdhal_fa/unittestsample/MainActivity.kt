package com.afdhal_fa.unittestsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.afdhal_fa.unittestsample.movie.presentation.MovieListActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupView()
    }

    private fun setupView() {
        val button = findViewById<MaterialButton>(R.id.btnMovies)
        button.setOnClickListener {
            MovieListActivity.start(this)
        }
    }
}