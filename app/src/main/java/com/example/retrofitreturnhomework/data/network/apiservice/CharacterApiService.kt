package com.example.retrofitreturnhomework.data.network.apiservice

import com.example.retrofitreturnhomework.model.CharacterModel
import com.example.retrofitreturnhomework.model.RickyAndMortyResponse
import retrofit2.Call
import retrofit2.http.GET

interface CharacterApiService  {

    @GET ("api/character")
    fun fetchCharacters () : Call<RickyAndMortyResponse<CharacterModel>>


}
