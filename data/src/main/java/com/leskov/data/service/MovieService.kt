package com.leskov.data.service

import com.leskov.data.constants.UrlConstants
import retrofit2.http.GET

interface MovieService {

    @GET(UrlConstants.POPULAR_MOVIES)
    suspend fun fetchPopularMovies() // TODO: Complete return type

    class Base(private val service: MovieService) {
        suspend fun fetchPopularMovies() = service.fetchPopularMovies()
    }
}