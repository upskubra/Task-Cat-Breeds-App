package com.example.catbreeds

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CatListRecyclerAdapter(private val list: List<CatModel>): RecyclerView.Adapter<CatListRecyclerAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


       val textView: TextView = itemView.findViewById(R.id.recycler_item_textView)
        val imageView: ImageView = itemView.findViewById(R.id.recycler_item_imageView)
    }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
            return ViewHolder(view)
        }

        override fun getItemCount(): Int = list.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            // before create detail fragment
            //val cat = list[position]
            //holder.textView.text = cat.name
            //holder.imageView.loadImage(cat.imageUrl)
        }
    }