package com.mobile.bluepillow.ui

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.mobile.bluepillow.databinding.WorldItemBinding

@SuppressLint("NotifyDataSetChanged")
class WorldAdapter(private val worlds: LiveData<List<String>>, lifecycleOwner: LifecycleOwner) : RecyclerView.Adapter<WorldAdapter.WorldViewHolder>() {

    init {
        worlds.observe(lifecycleOwner){
            notifyDataSetChanged()
        }
    }

    private val TAG = "WorldAdapter"
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



    override fun getItemCount() = worlds.value?.size?:0

    override fun onBindViewHolder(holder: WorldViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder: "+ worlds.value?.get(position)!!)
        holder.bind(worlds.value?.get(position)!!)
    }


}