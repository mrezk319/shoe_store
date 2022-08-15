package com.udacity.shoestore

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShareViewModel : ViewModel() {
    init {
        Timber.i("ViewMOdel Created")

    }

    private var _shoesList = MutableLiveData<MutableList<Shoe>>(mutableListOf())
    val shoesList: LiveData<MutableList<Shoe>>
        get() = _shoesList


    init {
        _shoesList.value!!.add(Shoe("Ligra 7 M",38.0,"adidas","Lace closure."))
        _shoesList.value!!.add(Shoe("F18 - Sportive Lace-Up Running",45.0,"Desert","Comfortable Canvas upper material."))
    }


}