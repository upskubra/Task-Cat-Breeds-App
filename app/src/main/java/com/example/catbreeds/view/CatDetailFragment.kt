package com.example.catbreeds.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.catbreeds.R
import com.example.catbreeds.databinding.FragmentCatDetailBinding


class CatDetailFragment : Fragment() {

    // set data binding
    private lateinit var binding: FragmentCatDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cat_detail, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.catDetailBack.setOnClickListener {
            val action = CatDetailFragmentDirections.actionCatDetailFragmentToCatListFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }

}