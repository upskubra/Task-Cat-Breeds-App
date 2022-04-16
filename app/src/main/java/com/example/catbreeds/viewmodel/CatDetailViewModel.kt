package com.example.catbreeds.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.catbreeds.model.CatModelItem

class CatDetailViewModel : ViewModel() {

    private val catLiveData = MutableLiveData<CatModelItem>()

    fun getCatLiveData(): MutableLiveData<CatModelItem> {
        return catLiveData
    }

}
