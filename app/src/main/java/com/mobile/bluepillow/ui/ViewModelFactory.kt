package com.mobile.bluepillow.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.core_data.repository.WorldRepository

class ViewModelFactory(val repository: com.example.core_data.repository.WorldRepository):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>)= when(modelClass) {
        MainViewModel::class.java -> MainViewModel(repository) as T
        else -> throw java.lang.IllegalArgumentException("Unknown ViewModel")
    }

}