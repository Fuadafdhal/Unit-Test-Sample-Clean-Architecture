package com.afdhal_fa.unittestsample.movie.data.response

import com.squareup.moshi.Json

/**
 * Created by Muh Fuad Afdhal on 9/27/2021
 * Email: fuad.afdal.fa@gmail.com
 */

class GetPopularMoviesDto(
    @field:Json(name = "page")
    val page: Int? = null,
    @field:Json(name = "results")
    val results: List<Result>? = null,
    @field:Json(name = "total_pages")
    val totalPages: Int? = null,
    @field:Json(name = "total_results")
    val totalResults: Int? = null
) {
    data class Result(
        @field:Json(name = "adult")
        val adult: Boolean? = null,
        @field:Json(name = "backdrop_path")
        val backdropPath: String? = null,
        @field:Json(name = "genre_ids")
        val genreIds: List<Int?>? = null,
        @field:Json(name = "id")
        val id: Int? = null,
        @field:Json(name = "original_language")
        val originalLanguage: String? = null,
        @field:Json(name = "original_title")
        val originalTitle: String? = null,
        @field:Json(name = "overview")
        val overview: String? = null,
        @field:Json(name = "popularity")
        val popularity: Double? = null,
        @field:Json(name = "poster_path")
        val posterPath: String? = null,
        @field:Json(name = "release_date")
        val releaseDate: String? = null,
        @field:Json(name = "title")
        val title: String? = null,
        @field:Json(name = "video")
        val video: Boolean? = null,
        @field:Json(name = "vote_average")
        val voteAverage: Double? = null,
        @field:Json(name = "vote_count")
        val voteCount: Int? = null
    )
}