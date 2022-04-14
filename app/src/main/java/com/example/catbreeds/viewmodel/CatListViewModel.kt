package com.example.catbreeds.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.catbreeds.model.CatModelItem

class CatListViewModel : ViewModel() {

    private val cats = MutableLiveData<List<CatModelItem>>()


}
