package com.example.retrofitreturnhomework.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofitreturnhomework.databinding.ItemCharacterBinding
import com.example.retrofitreturnhomework.model.CharacterModel

class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    lateinit var binding: ItemCharacterBinding
    private var list: ArrayList<CharacterModel> = ArrayList()

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
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

      fun addAllList (model : ArrayList<CharacterModel>) {
           list.addAll(model)
          notifyDataSetChanged()

      }

}

