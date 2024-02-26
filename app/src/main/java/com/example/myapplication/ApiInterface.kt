package com.example.myapplication

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface{
@GET("v3/9ba4ce56-e933-4e43-97ae-a3caa234d80c")
fun getData(): Call<responceDataClass>
}