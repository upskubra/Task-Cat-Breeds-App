package com.example.catbreeds.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.catbreeds.R
import com.example.catbreeds.databinding.RecyclerViewItemBinding
import com.example.catbreeds.model.CatModelItem
import com.example.catbreeds.view.CatListFragmentDirections

class CatListRecyclerAdapter(var list: ArrayList<CatModelItem>) :
    RecyclerView.Adapter<CatListRecyclerAdapter.CatViewHolder>() {


    class CatViewHolder(var view: RecyclerViewItemBinding) : RecyclerView.ViewHolder(view.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        //val view = inflater.inflate(R.layout.item_country,parent,false)
        val view = DataBindingUtil.inflate<RecyclerViewItemBinding>(
            inflater,
            R.layout.recycler_view_item,
            parent,
            false
        )
        return CatViewHolder(view)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.view.cats = list[position]
        holder.view.root.setOnClickListener {
            val action = CatListFragmentDirections.actionCatListFragmentToCatDetailFragment()
            action.uid = list[position].uid
            Navigation.findNavController(it).navigate(action)
        }
    }

    fun updateCatList(newCatList: List<CatModelItem>) {
        list.clear()
        list.addAll(newCatList)
        notifyDataSetChanged()
    }
}