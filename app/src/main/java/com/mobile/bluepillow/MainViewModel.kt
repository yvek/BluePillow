package com.mobile.bluepillow

import androidx.lifecycle.ViewModel

class MainViewModel(var param:String): ViewModel() {
    val text = "Hello World $param"


}