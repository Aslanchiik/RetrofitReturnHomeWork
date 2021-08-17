package com.example.retrofitreturnhomework.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.retrofitreturnhomework.data.network.apiservice.LocationApiService
import com.example.retrofitreturnhomework.data.repositories.pagingsources.LocationsPagingSource
import com.example.retrofitreturnhomework.model.LocationModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocationsRepos @Inject constructor(private  var service: LocationApiService)  {

    fun fetchLocation(): Flow<PagingData<LocationModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                LocationsPagingSource(service)
            }).flow
    }
}