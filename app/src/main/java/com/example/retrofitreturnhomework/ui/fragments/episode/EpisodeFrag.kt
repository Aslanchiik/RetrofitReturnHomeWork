package com.example.retrofitreturnhomework.ui.fragments.episode

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.retrofitreturnhomework.R
import com.example.retrofitreturnhomework.base.BaseFragment
import com.example.retrofitreturnhomework.databinding.FragmentEpisodeBinding
import com.example.retrofitreturnhomework.ui.adapters.EpisodeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@AndroidEntryPoint
class EpisodeFrag : BaseFragment<FragmentEpisodeBinding, EpisodeViewModel>(R.layout.fragment_episode) {

    override val binding by viewBinding(FragmentEpisodeBinding::bind)

    override val viewModel: EpisodeViewModel by viewModels()

    private var episodeAdapter : EpisodeAdapter = EpisodeAdapter()

    override fun setupViews() {
         binding.recViewEpisode.apply {
             layoutManager = LinearLayoutManager(context)
             adapter = episodeAdapter
         }
    }

    override fun setupRequest() {
        lifecycleScope.launch {
            viewModel.hiltEpisode().collectLatest {
                episodeAdapter.submitData(it)
            }
        }
    }
}