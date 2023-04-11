package com.mobile.bluepillow.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.mobile.bluepillow.databinding.WorldItemBinding
import com.mobile.bluepillow.model.World

class WorldAdapter(private val worlds: List<String>) : RecyclerView.Adapter<WorldAdapter.WorldViewHolder>() {



    val TAG = "WorldAdapter"
    inner class WorldViewHolder(private val binding:WorldItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(world:String){
            binding.apply{
                data = world
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorldViewHolder {
        val binding = WorldItemBinding.inflate(LayoutInflater.from(parent.context))

        return WorldViewHolder(binding)
    }

    override fun getItemCount() = worlds.size

    override fun onBindViewHolder(holder: WorldViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder: "+worlds[position])
        holder.bind(worlds[position])
    }


}