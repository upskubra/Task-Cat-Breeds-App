package com.example.catbreeds.viewmodel

import android.media.Image
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.catbreeds.R
import com.example.catbreeds.model.CatModelItem

class CatListViewModel : ViewModel() {

    val cats = MutableLiveData<List<CatModelItem>>()
    // sample data
    val cat1 = CatModelItem(
        " ", 1,
        " ", " ", "", "",
        " ", " ", " "
    )
    val cat2 = CatModelItem(
        " ", 1,
        " ", " ", "", "",
        " ", " ", " "
    )

    val catsListSample : List<CatModelItem> = listOf(cat1, cat2)

    fun getCats() {
        cats.value = catsListSample
    }
}
