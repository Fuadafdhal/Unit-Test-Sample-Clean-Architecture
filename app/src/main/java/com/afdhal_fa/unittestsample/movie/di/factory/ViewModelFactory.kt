package com.afdhal_fa.unittestsample.movie.di.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

/**
 * Created by Muh Fuad Afdhal on 9/27/2021
 * Email: fuad.afdal.fa@gmail.com
 */

@Singleton
class ViewModelFactory @Inject constructor(
    private val viewModel: MutableMap<Class<out ViewModel>, Provider<ViewModel>>
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        viewModel[modelClass]?.get() as T
}