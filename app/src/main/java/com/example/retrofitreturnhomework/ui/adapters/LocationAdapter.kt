package com.example.retrofitreturnhomework.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitreturnhomework.databinding.ItemLocationBinding
import com.example.retrofitreturnhomework.model.LocationModel

class LocationAdapter : PagingDataAdapter<LocationModel, LocationAdapter.ViewHolder>(diffCallback) {

    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {

        private val binding = ItemLocationBinding.bind(view)

        fun bind(locationModel: LocationModel) {
            binding.itemLocationText.text = locationModel.name
            binding.itemLocationType.text = locationModel.type
        }

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding  =
            ItemLocationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding.root)
    }

    companion object {

        val diffCallback = object : DiffUtil.ItemCallback<LocationModel>() {
            override fun areItemsTheSame(
                oldItem: LocationModel,
                newItem: LocationModel,
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: LocationModel,
                newItem: LocationModel,
            ): Boolean {
                return oldItem == newItem
            }

        }
    }
}