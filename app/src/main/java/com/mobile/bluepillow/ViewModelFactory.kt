package com.mobile.bluepillow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory(var param:String):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>)= when(modelClass) {
        MainViewModel::class.java -> MainViewModel(param) as T
        else -> throw java.lang.IllegalArgumentException("Unknown ViewModel")
    }

}