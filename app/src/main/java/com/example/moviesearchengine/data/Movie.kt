package com.example.moviesearchengine.data

import android.media.Image
import com.google.gson.annotations.SerializedName

class MovieList (
    @SerializedName("Search") val search: List<Movie>
) {
}

data class Movie (
    @SerializedName("imdbID") val id: Int,
    @SerializedName("Title") val title: String,
    @SerializedName("Year") val year: String,
    @SerializedName("Poster") val image: Image,
    @SerializedName("Plot") val plot: String,
    @SerializedName("Runtime") val runtime: String,
    @SerializedName("Director") val director: String,
    @SerializedName("Genre") val genre: String,
    @SerializedName("Country") val country: String
) {
}