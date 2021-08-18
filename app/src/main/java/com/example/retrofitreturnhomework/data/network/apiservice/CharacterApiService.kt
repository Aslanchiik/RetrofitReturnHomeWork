package com.example.retrofitreturnhomework.data.network.apiservice

import com.example.retrofitreturnhomework.model.CharacterModel
import com.example.retrofitreturnhomework.model.RickyAndMortyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterApiService {

    @GET("api/character")
    suspend fun fetchCharacters(@Query("page") page: Int): RickyAndMortyResponse<CharacterModel>

    @GET("api/character/{id}")
    fun fetchIdCharacter(@Path("id") id: Int? = null) : Call<CharacterModel>


}
