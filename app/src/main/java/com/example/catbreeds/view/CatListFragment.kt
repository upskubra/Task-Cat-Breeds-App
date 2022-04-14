package com.example.catbreeds.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.catbreeds.R
import com.example.catbreeds.adapter.CatListRecyclerAdapter
import com.example.catbreeds.databinding.FragmentCatListBinding
import com.example.catbreeds.viewmodel.CatListViewModel

class CatListFragment : Fragment() {
    private lateinit var binding: FragmentCatListBinding
    private lateinit var viewModel: CatListViewModel
    private val catAdapter = CatListRecyclerAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cat_list, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(CatListViewModel::class.java)
        viewModel.refreshData()
        observeLiveData()
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = catAdapter
    }

    private fun observeLiveData() {
        viewModel.cats.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            it.let {
                binding.recyclerView.visibility = View.VISIBLE
                catAdapter.updateCatList(it)
            }
        })
    }
}
