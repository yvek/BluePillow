package com.mobile.bluepillow.ui

import android.graphics.drawable.Drawable
import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobile.bluepillow.config.Configuration
import com.example.core_data.repository.WorldRepository
import com.squareup.picasso.Picasso
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val worldRepository: com.example.core_data.repository.WorldRepository
): ViewModel() {

    private val TAG = "MainViewModel"

    // default home screen icon
    val appImage = Configuration.homeIconUrl

    // data holders
    private val list = MutableLiveData<List<String>>()
    val exposeList: LiveData<List<String>> = list

    //error state
    var errorMessage = ""

    init {
        Log.d(TAG, "init")
        //initialise data with empty list
        list.value = listOf()

        //fetch list of worlds in background
        viewModelScope.launch(Dispatchers.IO){
            getWorlds()
        }

    }

    suspend fun getWorlds(){
        //fetch worlds list
        val data =  worldRepository.getWorlds()

        //set state on Main thread
        withContext(Dispatchers.Main){
            list.value = data
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

    fun fetchApiResponse(){
        viewModelScope.launch {
            val response = worldRepository.fetchTestApiResponse()



        }
    }

    companion object
    {
        @JvmStatic
        @BindingAdapter("imageUrl","placeholder","error", requireAll = false)
        fun setImageUrl(view: ImageView , url:String?,placeholder:Drawable, error: Drawable){
            if (url != null) {
                if(url.isNotEmpty())
                    Picasso.get().load(url).error(error).into(view)
            }else
                view.setImageDrawable(placeholder)
        }
    }


}