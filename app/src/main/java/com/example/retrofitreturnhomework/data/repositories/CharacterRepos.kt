package com.example.retrofitreturnhomework.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.retrofitreturnhomework.data.network.apiservice.CharacterApiService
import com.example.retrofitreturnhomework.data.repositories.pagingsources.CharacterPagingSource
import com.example.retrofitreturnhomework.model.CharacterModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class CharacterRepos @Inject constructor(private var service : CharacterApiService) {

    fun fetchCharacters(): Flow<PagingData<CharacterModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                CharacterPagingSource(service)
            }).flow
    }


}