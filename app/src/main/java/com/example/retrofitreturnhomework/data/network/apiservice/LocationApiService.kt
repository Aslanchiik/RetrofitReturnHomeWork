package com.example.retrofitreturnhomework.data.network.apiservice

import com.example.retrofitreturnhomework.model.LocationModel
import com.example.retrofitreturnhomework.model.RickyAndMortyResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface LocationApiService {

    @GET ("api/location")
     suspend fun fetchLocations (@Query ("page") page : Int) : RickyAndMortyResponse<LocationModel>
}