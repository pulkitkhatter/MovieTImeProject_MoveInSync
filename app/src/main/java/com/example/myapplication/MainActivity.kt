package com.example.myapplication

import android.content.Intent
import android.graphics.Movie
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      var viewPager=findViewById(R.id.viewPager) as ViewPager
        var tableLayout=findViewById(R.id.tablayout1) as TabLayout
        val fragmentAdapter=FragementAdapter(supportFragmentManager)
        fragmentAdapter.addFragment(BlankFragment1(),"For You")
        fragmentAdapter.addFragment(BlankFragment2(),"Top Charts")
        fragmentAdapter.addFragment(BlankFragment3(),"Categories")
        viewPager.adapter=fragmentAdapter
        tableLayout.setupWithViewPager(viewPager)
    }
}