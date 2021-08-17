package com.example.retrofitreturnhomework.data.network.apiservice

import com.example.retrofitreturnhomework.model.EpisodeModel
import com.example.retrofitreturnhomework.model.RickyAndMortyResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface EpisodeApiService {

    @GET ("api/episode")
      suspend fun fetchEpisodes (@Query ("page") page : Int) : RickyAndMortyResponse<EpisodeModel>
}