package com.example.catbreeds.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.catbreeds.Data.CatsDatabase
import com.example.catbreeds.model.CatModelItem
import kotlinx.coroutines.launch
import javax.inject.Inject

class CatDetailViewModel @Inject constructor(application: Application) : BaseViewModel(application) {

    val catLiveData = MutableLiveData<CatModelItem>()

    fun getDataFromDatabase(uid: Int) {
        launch {
            val dao = CatsDatabase(getApplication()).catDao()
            val cats = dao.loadAllByIds(uid)
            catLiveData.value = cats

        }
    }
}
