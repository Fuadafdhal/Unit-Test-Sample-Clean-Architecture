package com.afdhal_fa.unittestsample.movie.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.afdhal_fa.unittestsample.movie.abstraction.UseCase
import com.afdhal_fa.unittestsample.movie.domain.Result
import com.afdhal_fa.unittestsample.movie.domain.entity.Movie
import com.afdhal_fa.unittestsample.movie.domain.usecase.GetPopularMoviesUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Muh Fuad Afdhal on 10/3/2021
 * Email: fuad.afdal.fa@gmail.com
 */

class MovieListViewModel @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase
) : ViewModel() {
    private val _popularMovies = MutableLiveData<Result<List<Movie>>>()
    val popularMovies: LiveData<Result<List<Movie>>>
        get() = _popularMovies

    fun getPopularMovies() {
        _popularMovies.value = Result.Loading
        viewModelScope.launch {
            _popularMovies.value = getPopularMoviesUseCase.execute(UseCase.None)
        }
    }
}