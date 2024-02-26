package com.example.myapplication

// Category data model
data class MovieCategory(val title: String, val movies: List<MovieListFinal>)

// Movie data model
data class Movie(val title: String, val imageResId: Int)
