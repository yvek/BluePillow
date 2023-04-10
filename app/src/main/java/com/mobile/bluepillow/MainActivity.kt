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
import com.mobile.bluepillow.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //val viewModel by viewModels<MainViewModel>() // using activity ktx libraries
        //val vm = ViewModelProvider(this)[MainViewModel::class.java]  // using ViewModelProviders
        //val vm2 = ViewModelProviders.of(this).get(MainViewModel.class)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val repository = WorldRepository(this)
        val vm3 = ViewModelProvider(this,ViewModelFactory(repository))[MainViewModel::class.java]
        binding.apply {
            lifecycleOwner = this@MainActivity
            vm = vm3
        }

        }
}