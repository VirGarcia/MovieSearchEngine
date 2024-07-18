package com.example.moviesearchengine.data

import android.media.Image
import com.google.gson.TypeAdapter
import com.google.gson.annotations.SerializedName
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter

data class MovieResponse (
    @SerializedName("Search") val results: List<Movie>
    //@SerializedName("Search") val search: String,
    //@SerializedName("response") val response: String,
    //@SerializedName("results") val results: List<Movie>,
    //@SerializedName("Search") val search: List<Movie>

    //@SerializedName("results-for") val resultsFor: String?,
    //@SerializedName("results") val results: List<Superhero>
){
}

data class Movie (
    //@SerializedName("name") val name: String,
    @SerializedName("imdbID") val id: String,
    @SerializedName("Title") val title: String,
    @SerializedName("Year") val year: String,
    @SerializedName("Poster") val image: String,
    @SerializedName("Plot") val plot: String?,
    @SerializedName("Runtime") val runtime: String?,
    @SerializedName("Director") val director: String?,
    @SerializedName("Genre") val genre: String?,
    @SerializedName("Country") val country: String?
) {
}

data class Image (
    @SerializedName("url") val url: String
)

class IntegerAdapter : TypeAdapter<Int>() {
    override fun write(out: JsonWriter?, value: Int) {
        out?.value(value)
    }

    override fun read(`in`: JsonReader?): Int {
        if (`in` != null) {
            val value: String = `in`.nextString()
            if (value != "null") {
                return value.toInt()
            }
        }
        return 0
    }
}