package com.example.catbreeds.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.catbreeds.R
import com.example.catbreeds.databinding.FragmentCatDetailBinding
import com.example.catbreeds.viewmodel.CatDetailViewModel


class CatDetailFragment : Fragment() {

    // set data binding
    private lateinit var binding: FragmentCatDetailBinding
    private lateinit var viewModel: CatDetailViewModel
    private var uid: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cat_detail, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        arguments?.let {

            uid = CatDetailFragmentArgs.fromBundle(it).uid
        }
        viewModel = ViewModelProvider(this).get(CatDetailViewModel::class.java)
        viewModel.getDataFromDatabase(uid)


        binding.catDetailBack.setOnClickListener {
            val action = CatDetailFragmentDirections.actionCatDetailFragmentToCatListFragment()
            Navigation.findNavController(it).navigate(action)
        }


        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.catLiveData.observe(viewLifecycleOwner, Observer {
            it?.let { cat ->
                binding.selectedCat = cat
            }
        })
    }
}