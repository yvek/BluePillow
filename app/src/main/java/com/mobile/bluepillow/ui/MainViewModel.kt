package com.mobile.bluepillow.ui

import android.graphics.drawable.Drawable
import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bp.core_data.repository.WorldRepository
import com.squareup.picasso.Picasso
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val worldRepository: WorldRepository
): ViewModel() {

    // default home screen icon
    val appImage = worldRepository.homeUrl

    // data holders
    private val list = MutableLiveData<List<String>>()
    val exposeList: LiveData<List<String>> = list

    //private val jsonData = SharedFlow<TestResponse>

    //error state
    var errorMessage = ""

    init {
        Log.d(TAG, "init")
        //initialise data with empty list
        list.value = listOf()

        //fetch list of worlds in background
        viewModelScope.launch(Dispatchers.IO){
            async{
                getWorlds()
            }
            async {
                fetchApiResponse()
            }

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

    suspend fun fetchApiResponse(){
            worldRepository.fetchTestApiResponse(
                {},
                {}
            ) {message,code ->
                Log.d(TAG, "fetchApiResponse: $code Error: $message ")
            }.collect{
                Log.d(TAG, "fetchApiResponse: $it")
            }
     }

    companion object
    {
        const val TAG = "MainViewModel"
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