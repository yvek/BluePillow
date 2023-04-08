package com.mobile.bluepillow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mobile.bluepillow.data.WorldRepository

class ViewModelFactory(val repository: WorldRepository):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>)= when(modelClass) {
        MainViewModel::class.java -> MainViewModel(repository) as T
        else -> throw java.lang.IllegalArgumentException("Unknown ViewModel")
    }

}