package com.example.retrofitreturnhomework.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitreturnhomework.base.BaseDiffUtil
import com.example.retrofitreturnhomework.databinding.ItemEpisodeBinding
import com.example.retrofitreturnhomework.model.EpisodeModel

class EpisodeAdapter : PagingDataAdapter<EpisodeModel, EpisodeAdapter.ViewHolder>(BaseDiffUtil<EpisodeModel>()) {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = ItemEpisodeBinding.bind(view)

        fun bind(episodeModel: EpisodeModel) {
            binding.itemEpisodeTitle.text = episodeModel.name
            binding.itemEpisodeDescription.text = episodeModel.episode
        }


    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemEpisodeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding.root)
    }
}