package com.example.catbreeds.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.catbreeds.API.RetrofitBuilder
import com.example.catbreeds.model.CatModelItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class CatListViewModel : ViewModel() {

    private var retrofitBuilder = RetrofitBuilder()
    private var disposable = CompositeDisposable() // for disposing the api calls

    val cats = MutableLiveData<List<CatModelItem>>()


    fun refreshData() {
        getDataAPI()
    }
    private fun getDataAPI() {
        disposable.add(
            retrofitBuilder.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<CatModelItem>>() {
                    override fun onSuccess(t: List<CatModelItem>) {
                        cats.value = t
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }
                })
        )

    }

    override fun onCleared() {
        super.onCleared()

        disposable.clear()
    }
}
