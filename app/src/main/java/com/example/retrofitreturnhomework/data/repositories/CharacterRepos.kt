package com.example.retrofitreturnhomework.data.repositories

import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.retrofitreturnhomework.data.network.apiservice.CharacterApiService
import com.example.retrofitreturnhomework.data.repositories.pagingsources.CharacterPagingSource
import com.example.retrofitreturnhomework.model.CharacterModel
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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
    fun fetchGetDescription(id: Int? = null): MutableLiveData<CharacterModel> {
        val liveData: MutableLiveData<CharacterModel> = MutableLiveData()
        service.fetchIdCharacter(id)
            .enqueue(object : Callback<CharacterModel> {
                override fun onResponse(
                    call: Call<CharacterModel>,
                    response: Response<CharacterModel>,
                ) {
                    liveData.value = response.body()
                }

                override fun onFailure(call: Call<CharacterModel>, t: Throwable) {
                    liveData.value = null
                }
            })
        return liveData
    }


}