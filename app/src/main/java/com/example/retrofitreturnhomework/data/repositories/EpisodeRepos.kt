package com.example.retrofitreturnhomework.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.retrofitreturnhomework.data.network.apiservice.EpisodeApiService
import com.example.retrofitreturnhomework.data.repositories.pagingsources.EpisodePagingSource
import com.example.retrofitreturnhomework.model.EpisodeModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class EpisodeRepos @Inject constructor(private var service: EpisodeApiService) {

    fun fetchEpisode(): Flow<PagingData<EpisodeModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                EpisodePagingSource(service)
            }).flow
    }
}