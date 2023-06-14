package com.example.apicheck

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apicheck.DataClass.MyData
import com.example.apicheck.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var myAdapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    //api calls

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://spotify23.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyInterface::class.java)

        val retrofitData = retrofitBuilder.getSearchData("Alan Walker","artists","3")

        retrofitData.enqueue(object: Callback<MyData?>{
            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {

                val responseBody = response.body()
                val artistsList = responseBody?.artists?.items!!

//                {Root}.artists.items[0].data.visuals.avatarImage.sources[0]
//                val photo = artistsList.data.visuals.avatarImage.sources[0].url
//                val name = artistsList.data.profile.name
                myAdapter = MyAdapter(this@MainActivity,artistsList)

                binding.recyclerView.adapter = myAdapter
                binding.recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            }

            override fun onFailure(call: Call<MyData?>, t: Throwable) {
                Log.d("Error",t.message.toString())
            }

        })

    }
}