package com.example.moviesearchengine.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import com.example.moviesearchengine.R
import com.example.moviesearchengine.data.Movie
import com.example.moviesearchengine.data.MovieApiService
import com.example.moviesearchengine.databinding.ActivityDetailBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding

    lateinit var movie: Movie

    lateinit var progressBar: ProgressBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getStringExtra("MOVIE_ID")

        getById(id!!)
    }

    private fun loadData() {
        binding.titleTextView.text = movie.title
        binding.yearTextView.text = movie.year
        binding.plotTextView.text = movie.plot
        binding.runtimeTextView.text = movie.runtime
        binding.directorTextView.text = movie.director
        binding.genreTextView.text = movie.genre
        binding.countryTextView.text = movie.country
        progressBar = findViewById(R.id.progressBar)
        Picasso.get().load(movie.image).into(binding.photoImageView)



    }

    private fun getById(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val apiService = getRetrofit().create(MovieApiService::class.java)
                val result = apiService.getMovieById(id)

                movie = result

                runOnUiThread {
                    loadData()
                    progressBar.visibility = View.GONE
                }
                //Log.i("HTTP", "${result.results}")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.omdbapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

}