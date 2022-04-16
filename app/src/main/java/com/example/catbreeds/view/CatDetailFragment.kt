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
import com.bumptech.glide.Glide
import com.example.catbreeds.R
import com.example.catbreeds.databinding.FragmentCatDetailBinding
import com.example.catbreeds.viewmodel.CatDetailViewModel


class CatDetailFragment : Fragment() {

    // set data binding
    private lateinit var binding: FragmentCatDetailBinding
    private lateinit var viewModel: CatDetailViewModel
    private lateinit var catName: String
    private lateinit var image: String
    private lateinit var origin: String
    private lateinit var url: String
    private lateinit var lifeSpan: String
    private var dogFriendly: Int? = null
    private lateinit var description: String

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

        viewModel = ViewModelProvider(this).get(CatDetailViewModel::class.java)
        viewModel.getCatLiveData()
        binding.catDetailBack.setOnClickListener {
            val action = CatDetailFragmentDirections.actionCatDetailFragmentToCatListFragment()
            Navigation.findNavController(it).navigate(action)
        }
        arguments?.let {
            catName = CatDetailFragmentArgs.fromBundle(it).catName
            image = CatDetailFragmentArgs.fromBundle(it).catImage
            dogFriendly = CatDetailFragmentArgs.fromBundle(it).catDogFriendly
            lifeSpan = CatDetailFragmentArgs.fromBundle(it).catLifeSpan
            origin = CatDetailFragmentArgs.fromBundle(it).catOrigin
            description = CatDetailFragmentArgs.fromBundle(it).catDescription
            url = CatDetailFragmentArgs.fromBundle(it).catWikiUrl
        }

        getData()
    }

    private fun getData() {
        binding.catDetailName.text = catName
        binding.catDetailDog.text = dogFriendly.toString()
        binding.catDetailLife.text = lifeSpan
        binding.catDetailOrigin.text = origin
        binding.catDetailTemperament.text = description
        binding.catDetailUrl.text = url

        try {
            val imageUrl = image
            Glide.with(this).load(imageUrl).into(binding.catDetailImage)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}