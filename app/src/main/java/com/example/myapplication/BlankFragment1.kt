package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BlankFragment1 : Fragment() {

    private var movieDetails: List<MovieDetailX>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_blank1, container, false)

        // Set click listeners for each ImageView
        val imageViews = listOf(
            R.id.imageViewMovie1, R.id.imageViewMovie2, R.id.imageViewMovie3, R.id.imageViewMovie4,
            R.id.imageViewMovie5, R.id.imageViewMovie6, R.id.imageViewMovie7, R.id.imageViewMovie8,
            R.id.imageViewMovie9, R.id.imageViewMovie10, R.id.imageViewMovie11, R.id.imageViewMovie12,
            R.id.imageViewMovie13, R.id.imageViewMovie14
        )

        imageViews.forEach { imageViewId ->
            view.findViewById<ImageView>(imageViewId)?.setOnClickListener {
                val index = imageViews.indexOf(imageViewId)
                movieDetails?.getOrNull(index)?.let { movieDetail ->
                    navigateToMainActivity2(movieDetail.movieName, movieDetail.genre, movieDetail.rating, movieDetail.imageUrl)
                }
            }
        }

        getData()
        return view
    }

    private fun getData() {
        RetrofitInstance.apiInterface.getData().enqueue(object : Callback<responceDataClass?> {
            override fun onResponse(
                call: Call<responceDataClass?>,
                response: Response<responceDataClass?>
            ) {
                if (response.isSuccessful) {
                    val responseData = response.body()
                    responseData?.let {
                        movieDetails = it.movieDetails
                        loadMovieImages(movieDetails)
                    }
                } else {
                    // Handle unsuccessful response here
                    Toast.makeText(requireContext(), "Failed to fetch data", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<responceDataClass?>, t: Throwable) {
                // Handle failure here
                Toast.makeText(requireContext(), "Network Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }

            private fun loadMovieImages(movieDetails: List<MovieDetailX>?) {
                movieDetails?.let {
                    val imageViewIds = listOf(
                        R.id.imageViewMovie1, R.id.imageViewMovie2, R.id.imageViewMovie3, R.id.imageViewMovie4,
                        R.id.imageViewMovie5, R.id.imageViewMovie6, R.id.imageViewMovie7, R.id.imageViewMovie8,
                        R.id.imageViewMovie9, R.id.imageViewMovie10, R.id.imageViewMovie11, R.id.imageViewMovie12,
                        R.id.imageViewMovie13, R.id.imageViewMovie14
                    )

                    it.forEachIndexed { index, movieDetail ->
                        val imageViewId = imageViewIds.getOrNull(index)
                        imageViewId?.let { id ->
                            val imageView = view?.findViewById<ImageView>(id)
                            if (imageView != null) {
                                Glide.with(requireContext())
                                    .load(movieDetail.imageUrl)
                                    .into(imageView)

                                // Set click listener
                                imageView.setOnClickListener {
                                    // Pass image data, movie name, genre, and rating
                                    navigateToMainActivity2(movieDetail.movieName, movieDetail.genre, movieDetail.rating, movieDetail.imageUrl)
                                }
                            }
                        }
                    }
                }
            }
        })
    }

    private fun navigateToMainActivity2(movieName: String, genre: String, rating: Double, imageUrl: String) {
        val intent = Intent(activity, MainActivity2::class.java)
        intent.putExtra("movieName", movieName)
        intent.putExtra("genre", genre)
        intent.putExtra("rating", rating)
        intent.putExtra("imageUrl", imageUrl)
        startActivity(intent)
    }

}
