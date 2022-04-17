package com.example.catbreeds.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.catbreeds.R
import com.example.catbreeds.databinding.RecyclerViewItemBinding
import com.example.catbreeds.model.CatModelItem
import com.example.catbreeds.view.CatListFragmentDirections

class CatListRecyclerAdapter(private val list: ArrayList<CatModelItem>) :
    RecyclerView.Adapter<CatListRecyclerAdapter.ViewHolder>() {

    class ViewHolder(itemView: RecyclerViewItemBinding) :
        RecyclerView.ViewHolder(itemView.root) {

        private val textView: TextView = itemView.recyclerItemName
        private val image: ImageView = itemView.recyclerItemImageView
        fun bind(cat: CatModelItem) {
            textView.text = cat.name
            try {
                val imageUrl: String = cat.image.url
                Glide.with(this.itemView.context).load(imageUrl).into(image)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val view = DataBindingUtil.inflate<RecyclerViewItemBinding>(
            inflater,
            R.layout.recycler_view_item,
            parent,
            false
        )
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
        holder.itemView.setOnClickListener {
            val action = CatListFragmentDirections.actionCatListFragmentToCatDetailFragment(
                list[position].name,
                list[position].origin,
                list[position].image.url,
                list[position].description,
                list[position].dogFriendly,
                list[position].wikipediaUrl,
                list[position].lifeSpan
            )
            it.findNavController().navigate(action)
        }
    }

    fun updateCatList(newCatList: List<CatModelItem>) {
        list.clear()
        list.addAll(newCatList)
        notifyDataSetChanged()
    }
}