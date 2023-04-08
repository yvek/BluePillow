package com.mobile.bluepillow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobile.bluepillow.data.WorldRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainViewModel(
val worldRepository: WorldRepository): ViewModel() {
    fun getWorlds(){
        viewModelScope.async(Dispatchers.IO) {
             getW()
        }
    }


    suspend fun getW():List<String>{
       return worldRepository.getWorlds()
    }

    suspend fun addWorld(text: String) {
        worldRepository.addWorld(text)
    }

}