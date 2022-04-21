package com.example.catbreeds.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.catbreeds.R
import com.example.catbreeds.adapter.CatListRecyclerAdapter
import com.example.catbreeds.databinding.FragmentCatListBinding
import com.example.catbreeds.model.CatModelItem
import com.example.catbreeds.viewmodel.CatListViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class CatListFragment : Fragment() {
    private lateinit var binding: FragmentCatListBinding
    private lateinit var viewModel: CatListViewModel
    private val catAdapter = CatListRecyclerAdapter(arrayListOf())
    var tempList = ArrayList<CatModelItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        (requireActivity() as AppCompatActivity?)?.supportActionBar?.show()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cat_list, container, false)
        return binding.root }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(CatListViewModel::class.java)
        viewModel.refreshData()

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = catAdapter

        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.cats.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            it.let {
                catAdapter.updateCatList(it)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.search_menu, menu)
        val menuItem = menu.findItem(R.id.menu_item_search)

        if (menuItem != null) {
            val searchView = menuItem.actionView as SearchView
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }

                @SuppressLint("NotifyDataSetChanged")
                override fun onQueryTextChange(newText: String?): Boolean {
                    if (newText!!.isNotEmpty()) {
                        tempList.clear()
                        val search = newText.lowercase(Locale.getDefault())
                        viewModel.cats.value?.forEach {
                            if (it.name?.lowercase(Locale.getDefault())!!.contains(search)) {
                                tempList.add(it)
                                Log.e("temp", tempList[0].name!!)
                            }
                        }
                        catAdapter.updateCatList(tempList)
                    } else {
                        tempList.clear()
                        viewModel.cats.value?.let { tempList.addAll(it) }
                        catAdapter.updateCatList(tempList)
                    }
                    return true
                }

            })
        }

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_item_fav -> {
                val action = CatListFragmentDirections.actionCatListFragmentToFavCatFragment()
                findNavController().navigate(action)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
