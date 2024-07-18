package com.example.moviesearchengine.data

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiService {
    @GET("characters?limit=100")
    suspend fun findAllMovies() : MovieList

    @GET("&s=")
    suspend fun findMoviesByTitle(@Query("Title") query: String) : MovieList

    @GET("&i=")
    suspend fun getMovieById(@Path("imdbID") id: Int) : Movie
}