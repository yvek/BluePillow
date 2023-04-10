package com.mobile.bluepillow

import android.database.Observable
import android.widget.EditText
import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobile.bluepillow.data.WorldRepository
import kotlinx.coroutines.*

class MainViewModel(
val worldRepository: WorldRepository): ViewModel() {
// kotlin classes initiliazation is top-to-bottom hence variables before init
    var list = MutableLiveData<List<String>>()
    var exposeList: LiveData<List<String>> = list
    var errorMessage = ""
    init {
        viewModelScope.launch{
            getWorlds()
        }

    }


    //@Bindable
    suspend fun getWorlds(){
        withContext(Dispatchers.Main){
            list.value = worldRepository.getWorlds()
        }
    }

    fun addWorld(text: String) {
        if(text.isNotEmpty())
        viewModelScope.launch (Dispatchers.IO) {
            worldRepository.addWorld(text)
            getWorlds()
        }
        else
            errorMessage = "Empty world!"
    }

}