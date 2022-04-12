package com.example.catbreeds

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.catbreeds.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        // sample data
        val cat1 = CatModel("5", "sdfjljjds", "dsfjfkdf", 5, 5)
        val cat2 = CatModel("5", "sdfjljjds", "dsfjfkdf", 5, 5)
        val list = listOf(cat1, cat2)

        setUpRecyclerView(list)


    }

    private fun setUpRecyclerView(list: List<CatModel>) {
        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        val adapter = CatListRecyclerAdapter(list)
        binding.recyclerView.adapter = adapter

    }

}