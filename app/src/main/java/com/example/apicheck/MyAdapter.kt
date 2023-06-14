package com.example.apicheck

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apicheck.DataClass.Item
import com.squareup.picasso.Picasso

class MyAdapter(private val context: Activity, val artistsArrayList: List<Item>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
        class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
         val title:TextView
         val image:ImageView
           init {
               title = itemView.findViewById(R.id.productTitle)
               image = itemView.findViewById(R.id.productImage)
           }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.each_items,parent,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return artistsArrayList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val currentArtists = artistsArrayList[position]
        holder.title.text = currentArtists.data.profile.name
        val imageurl = currentArtists.data.visuals.avatarImage.sources[0].url
        Picasso.get().load(imageurl).into(holder.image)
    }

}