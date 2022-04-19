package com.example.catbreeds.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.catbreeds.R
import com.example.catbreeds.databinding.FragmentFavCatBinding
import com.example.catbreeds.viewmodel.FavCatViewModel


class FavCatFragment : Fragment() {
    private lateinit var binding: FragmentFavCatBinding
    private lateinit var viewModel: FavCatViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_fav_cat, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(FavCatViewModel::class.java)

        binding.backBtn.setOnClickListener {
            val action = FavCatFragmentDirections.actionFavCatFragmentToCatListFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }

}