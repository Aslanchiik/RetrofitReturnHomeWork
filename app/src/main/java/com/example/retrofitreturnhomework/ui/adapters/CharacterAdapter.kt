package com.example.retrofitreturnhomework.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofitreturnhomework.databinding.ItemCharacterBinding
import com.example.retrofitreturnhomework.model.CharacterModel

class CharacterAdapter :

    PagingDataAdapter<CharacterModel, CharacterAdapter.ViewHolder>(diffCallback) {

    lateinit var binding: ItemCharacterBinding

    inner class ViewHolder(binding: ItemCharacterBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(position: CharacterModel) {
            Glide.with(binding.itemCharacterImage).load(position.image)
                .into(binding.itemCharacterImage)
            binding.itemCharacterText.text = position.name

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    companion object {

        val diffCallback = object : DiffUtil.ItemCallback<CharacterModel>() {
            override fun areItemsTheSame(
                oldItem: CharacterModel,
                newItem: CharacterModel,
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: CharacterModel,
                newItem: CharacterModel,
            ): Boolean {
                return oldItem == newItem
            }

        }
    }
}

