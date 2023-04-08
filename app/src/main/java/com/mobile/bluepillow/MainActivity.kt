package com.mobile.bluepillow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.mobile.bluepillow.data.WorldRepository
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //val viewModel by viewModels<MainViewModel>() // using activity ktx libraries
        //val vm = ViewModelProvider(this)[MainViewModel::class.java]  // using ViewModelProviders
        //val vm2 = ViewModelProviders.of(this).get(MainViewModel.class)

        val repository = WorldRepository(this)
        val vm3 = ViewModelProvider(this,ViewModelFactory(repository))[MainViewModel::class.java]
        GlobalScope.launch (Dispatchers.IO) {
            val size = vm3.getW().size
            withContext(Dispatchers.Main){
                findViewById<TextView>(R.id.tv).text = "We have $size worlds"
            }

        }
        findViewById<Button>(R.id.add_world).setOnClickListener{
            GlobalScope.launch (Dispatchers.IO) {
                vm3.addWorld(findViewById<EditText>(R.id.input).text.toString())
                val size = vm3.getW().size
                withContext(Dispatchers.Main){
                    findViewById<TextView>(R.id.tv).text = "We have $size worlds"
                }

            }
        }


    }



    override fun onResume() {
        super.onResume()
    }
}