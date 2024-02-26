package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class MovieCategoryAdapter(private val movieCategories: List<MovieCategory>) : RecyclerView.Adapter<MovieCategoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie_category, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movieCategory = movieCategories[position]
        holder.bind(movieCategory)
    }

    override fun getItemCount(): Int {
        return movieCategories.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewCategoryTitle: TextView = itemView.findViewById(R.id.textViewCategoryTitle)
        private val imageViewMovie1: ImageView = itemView.findViewById(R.id.imageViewMovie1)
        private val imageViewMovie2: ImageView = itemView.findViewById(R.id.imageViewMovie2)
        private val imageViewMovie3: ImageView = itemView.findViewById(R.id.imageViewMovie3)

        fun bind(movieCategory: MovieCategory) {
            textViewCategoryTitle.text = movieCategory.title
            if (movieCategory.movies.size >= 3) {
//                imageViewMovie1.setImageResource(movieCategory.movies[0].imageResId)
//                imageViewMovie2.setImageResource(movieCategory.movies[1].imageResId)
//                imageViewMovie3.setImageResource(movieCategory.movies[2].imageResId)
            }
        }
    }
}
