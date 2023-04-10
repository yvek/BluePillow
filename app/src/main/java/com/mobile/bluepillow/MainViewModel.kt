package com.mobile.bluepillow

import android.database.Observable
import android.graphics.drawable.Drawable
import android.widget.EditText
import android.widget.ImageView
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobile.bluepillow.config.Configuration
import com.mobile.bluepillow.data.WorldRepository
import com.squareup.picasso.Picasso
import kotlinx.coroutines.*

class MainViewModel(
val worldRepository: WorldRepository): ViewModel() {
// kotlin classes initiliazation is top-to-bottom hence variables before init
    val appImage = Configuration.homeIconUrl
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