package com.example.retrofitreturnhomework.ui.fragments.episode

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.retrofitreturnhomework.data.repositories.EpisodeRepos
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class EpisodeViewModel
@Inject constructor(private var repository: EpisodeRepos) : ViewModel() {

    fun hiltEpisode() = repository.fetchEpisode().cachedIn(viewModelScope)
}