package com.mobile.bluepillow.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.mobile.bluepillow.data.WorldRepository
import com.mobile.bluepillow.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel by lazy {
       ViewModelProvider(this)[MainViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //val viewModel by viewModels<MainViewModel>() // using activity ktx libraries
        //val vm = ViewModelProvider(this)[MainViewModel::class.java]  // using ViewModelProviders
        //val vm2 = ViewModelProviders.of(this).get(MainViewModel.class)
        setContentView(binding.root)

        binding.apply {
            lifecycleOwner = this@MainActivity // for observable fields
            vm = viewModel
            adapter = WorldAdapter(viewModel.exposeList,this@MainActivity)
        }


    }




}