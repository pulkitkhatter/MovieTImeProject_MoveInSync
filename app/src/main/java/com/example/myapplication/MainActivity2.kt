package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import java.util.Random

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Retrieve the rating, movie name, genre, and image URL from the intent extras
        val rating = intent.getDoubleExtra("rating", 0.0)
        val movieName = intent.getStringExtra("movieName") ?: "Unknown Movie"
        val genre = intent.getStringExtra("genre") ?: "Unknown Genre"
        val imageUrl = intent.getStringExtra("imageUrl") ?: ""

        // Find the Views in the layout
        val textViewRating: TextView = findViewById(R.id.textViewRating)
        val textViewMovieName: TextView = findViewById(R.id.textViewMovieName)
        val textViewGenre: TextView = findViewById(R.id.textViewGenre)
        val imageViewMovie: ImageView = findViewById(R.id.imageViewMovie)

        // Set the received information to the respective Views
        textViewRating.text = "Rating: $rating"
        textViewMovieName.text = "Movie Name: $movieName"
        textViewGenre.text = "Genre: $genre"

        // Load the image using Glide
        Glide.with(this)
            .load(imageUrl)
            .into(imageViewMovie)
        val textViewReleaseDate: TextView = findViewById(R.id.textViewReleaseDate)
        val textViewDirector: TextView = findViewById(R.id.textViewDirector)
        val textViewCast: TextView = findViewById(R.id.textViewCast)

        // Generate random values
        val random = Random()

        // Generate a random release date within the last 50 years
        val releaseYear = 1970 + random.nextInt(50)
        val releaseMonth = 1 + random.nextInt(12)
        val releaseDay = 1 + random.nextInt(28) // Considering 28 days for simplicity
        val releaseDate = String.format("%04d-%02d-%02d", releaseYear, releaseMonth, releaseDay)

        // Generate a random director name
        val directors = listOf("Random Director 1", "Random Director 2", "Random Director 3")
        val randomDirector = directors[random.nextInt(directors.size)]

        // Generate a random cast list
        val castList = listOf("Actor A", "Actress B", "Supporting Actor C", "Actor D", "Actress E")
        val randomCast = mutableListOf<String>()
        repeat(3) {
            val castMember = castList[random.nextInt(castList.size)]
            randomCast.add(castMember)
        }

        // Set the generated values to the TextViews
        textViewReleaseDate.text = "Release Date: $releaseDate"
        textViewDirector.text = "Director: $randomDirector"
        textViewCast.text = "Cast: ${randomCast.joinToString(", ")}"
    }
}
