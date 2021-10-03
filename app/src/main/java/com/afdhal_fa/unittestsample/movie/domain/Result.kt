package com.afdhal_fa.unittestsample.movie.domain

/**
 * Created by Muh Fuad Afdhal on 9/27/2021
 * Email: fuad.afdal.fa@gmail.com
 */

sealed class Result<out T> {
    object Loading : Result<Nothing>()
    object Empty : Result<Nothing>()
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(
        val cause: HttpResult = HttpResult.NOT_DEFINED,
        val code: Int? = null,
        val errorMessage: String? = null,
        val status: String? = null
    ) : Result<Nothing>()
}
