package com.example.moviesearchengine.data

import com.google.gson.TypeAdapter
import com.google.gson.annotations.SerializedName
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter

data class MovieResponse (
    @SerializedName("Search") val results: List<Movie>,
    @SerializedName("Response") val response: String


){
}

data class Movie (
    @SerializedName("imdbID") val id: String,
    @SerializedName("Title") val title: String,
    @SerializedName("Year") val year: String,
    @SerializedName("Type") val type: String,
    @SerializedName("Poster") val image: String,

    //hay q poner los interrogantes porque la primera vez q se llama solo trae 5 campos, luego
    //para obtener el resto hay que hacerlo llamando por el id.
    @SerializedName("Plot") val plot: String?,
    @SerializedName("Runtime") val runtime: String?,
    @SerializedName("Director") val director: String?,
    @SerializedName("Genre") val genre: String?,
    @SerializedName("Country") val country: String?
) {
}

//no hace falta clase IMAGE porque en este caso poster es tipo string y ahi viene la url.
//en el caso del superheroe la imagen venia como objeto por eso haciamos lo de data class image


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