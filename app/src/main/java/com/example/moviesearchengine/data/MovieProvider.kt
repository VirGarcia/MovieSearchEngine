package com.example.moviesearchengine.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieProvider {

    suspend fun getAllMovies() : List<Movie> {
        val apiService = getRetrofit().create(MovieApiService::class.java)
        val result = apiService.findAllMovies()
        return result.items
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://www.omdbapi.com/?apikey=fb7aca4")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}