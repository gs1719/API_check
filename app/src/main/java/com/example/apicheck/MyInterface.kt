package com.example.apicheck

import com.example.apicheck.DataClass.MyData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface MyInterface {
    @Headers(
//     your key
        "X-RapidAPI-Key: ",
        "X-RapidAPI-Host:spotify23.p.rapidapi.com"
    )
    @GET("search/")
    fun getSearchData(@Query("q") query: String,@Query("type")type:String,@Query("limit")limit:String): Call<MyData>

}