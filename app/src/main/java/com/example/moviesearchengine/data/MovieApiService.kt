package com.example.moviesearchengine.data

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiService {
    /*@GET("characters?limit=100")
    suspend fun findAllMovies() : MovieList*/

    /*@GET("&s={Title}")
    suspend fun findMoviesByTitle(@Query("Title") query: String) : MovieResponse*/

    @GET("/?apikey=fb7aca4")
    suspend fun findMoviesByTitle(@Query("s") query: String) : MovieResponse

    @GET("/?apikey=fb7aca4")
    suspend fun getMovieById(@Query("i") query: String) : Movie


}