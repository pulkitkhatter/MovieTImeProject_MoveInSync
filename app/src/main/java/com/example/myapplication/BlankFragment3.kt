package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView


class BlankFragment3 : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_blank3, container, false)

        val listView: ListView = view.findViewById(R.id.listViewCategories)

        val categoryArray = arrayOf(
            "Action",
            "Adventure",
            "Animation",
            "Biography",
            "Comedy",
            "Crime",
            "Documentary",
            "Drama",
            "Family",
            "Fantasy",
            "Film Noir",
            "History",
            "Horror",
            "Music",
            "Musical",
            "Mystery",
            "Romance",
            "Sci-Fi",
            "Short Film",
            "Sport",
            "Superhero",
            "Thriller",
            "War",
            "Western",
            "Experimental",
            "Fantasy",
            "Magic Realism",
            "Psychological Thriller",
            "Satire",
            "Surreal",
            "Suspense",
            "Neo-noir",
            "Black Comedy",
            "Classic",
            "Foreign",
            "Independent",
            "Noir",
            "Parody",
            "Social Realism",
            "Urban",
            "Biopic",
            "Disaster",
            "Epic",
            "Mockumentary",
            "Zombie"
        )


        val sortedCategoryArray = categoryArray.sortedArray()

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, sortedCategoryArray)
        listView.adapter = adapter

        return view
    }

}