package com.afdhal_fa.unittestsample.movie.presentation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.afdhal_fa.unittestsample.R
import com.afdhal_fa.unittestsample.databinding.ActivityMovieListBinding
import com.afdhal_fa.unittestsample.movie.abstraction.BaseActivity
import com.afdhal_fa.unittestsample.movie.domain.Result
import com.afdhal_fa.unittestsample.movie.util.gone
import com.afdhal_fa.unittestsample.movie.util.visible
import java.security.AccessControlContext

class MovieListActivity : BaseActivity<ActivityMovieListBinding,MovieListViewModel>() {

    override fun getLayoutResourceId(): Int  = R.layout.activity_movie_list
    override fun getViewModelClass(): Class<MovieListViewModel>  = MovieListViewModel::class.java

    private val adapter by lazy { MovieRecyclerAdapter() }

    companion object{
        fun start(context: Context){
            val starter = Intent(context,MovieListActivity::class.java)
            context.startActivity(starter)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupRecyclerView()
        observePopularMovies()
        vm.getPopularMovies()
    }

    private fun setupRecyclerView() {
        val layoutManager= GridLayoutManager(this,2)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter
        adapter.setOnMovieSelected {

        }
    }

    private fun observePopularMovies() {
        vm.popularMovies.observe(this ){
            when(it){
                is Result.Loading->{
                    binding.progressBar.visible()
                }
                is Result.Success->{
                    binding.progressBar.gone()
                    adapter.submitList(it.data)
                }
                is Result.Error->{
                    binding.progressBar.gone()
                }
            }
        }
    }
}