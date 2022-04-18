package com.example.catbreeds.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.catbreeds.API.CatsDatabase
import com.example.catbreeds.API.RetrofitBuilder
import com.example.catbreeds.Util.CustomSharedPreferences
import com.example.catbreeds.model.CatModelItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch

class CatListViewModel(application: Application) : BaseViewModel(application = application) {

    private var retrofitBuilder = RetrofitBuilder()
    private var disposable = CompositeDisposable() // for disposing the api calls
    private var customPreferences = CustomSharedPreferences(getApplication())
    private var refreshTime = 0 * 60 * 1000 * 1000 * 1000L // 10 minutes in nanoseconds


    val cats = MutableLiveData<List<CatModelItem>>()


    fun refreshData() {
        val updateTime = customPreferences.getTime()
        if (updateTime != null && updateTime != 0L && System.nanoTime() - updateTime < refreshTime) {
            Log.e("CatListViewModel", "Data is up to date")
            getDataFromDatabase()
        } else {
            Log.e("CatListViewModel", "Data is out of date")
            getDataAPI()
        }

    }

    fun refreshFromAPI() {
        getDataAPI()
    }


    private fun getDataFromDatabase() {
        launch {
            val dao = CatsDatabase(getApplication()).catDao()
            val cats = dao.getAll()
            showCat(cats)
        }
    }

    private fun getDataAPI() {
        disposable.add(
            retrofitBuilder.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<CatModelItem>>() {
                    override fun onSuccess(t: List<CatModelItem>) {
                        storeInDB(t)
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }
                })
        )

    }

    private fun showCat(list: List<CatModelItem>) {
        cats.value = list
    }

    private fun storeInDB(list: List<CatModelItem>) {

        launch {
            val dao = CatsDatabase(getApplication()).catDao()
            dao.deleteAll(list)
            val listLong = dao.insertAll(*list.toTypedArray())
            var i = 0
            while (i < list.size) {
                list[i].uid = listLong[i].toInt()
                i++
            }
            showCat(list)
        }
        customPreferences.saveTime(System.nanoTime())
    }

    override fun onCleared() {
        super.onCleared()

        disposable.clear()
    }
}
