package com.example.catbreeds.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.catbreeds.adapter.CatListRecyclerAdapter
import com.example.catbreeds.model.CatModel
import com.example.catbreeds.R
import com.example.catbreeds.databinding.FragmentCatListBinding

class CatListFragment : Fragment() {
    private lateinit var binding: FragmentCatListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cat_list, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
// sample data
        val cat1 = CatModel("5", "sdfjljjds", "dsfjfkdf", 5, 5)
        val cat2 = CatModel("5", "sdfjljjds", "dsfjfkdf", 5, 5)
        val cat_list = listOf(cat1, cat2)

        setUpRecyclerView(cat_list)
    }


    private fun setUpRecyclerView(list: List<CatModel>) {
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = CatListRecyclerAdapter(list)
    }
}