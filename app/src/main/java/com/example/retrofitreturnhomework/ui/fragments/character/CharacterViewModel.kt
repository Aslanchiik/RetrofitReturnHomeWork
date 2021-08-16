package com.example.retrofitreturnhomework.ui.fragments.character

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitreturnhomework.App
import com.example.retrofitreturnhomework.model.CharacterModel
import com.example.retrofitreturnhomework.model.RickyAndMortyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharacterViewModel : ViewModel() {


    fun getCharacter() : MutableLiveData<RickyAndMortyResponse<CharacterModel>>{

        val data: MutableLiveData<RickyAndMortyResponse<CharacterModel>> = MutableLiveData()

        App().characterApiService?.fetchCharacters()?.enqueue(object : Callback<RickyAndMortyResponse<CharacterModel>>{
             override fun onResponse(
                 call: Call<RickyAndMortyResponse<CharacterModel>>,
                 response: Response<RickyAndMortyResponse<CharacterModel>>,
             ) {
                 data.value = response.body()
             }

             override fun onFailure(
                 call: Call<RickyAndMortyResponse<CharacterModel>>,
                 t: Throwable,
             ) {
                 Log.e("tag", "da")
                 data.value = null
             }

         })

//            ?.enqueue(object : retrofit2.Callback<RickyAndMortyResponse<CharacterModel>> {
//
//                override fun onResponse(
//                    call: Call<RickyAndMortyResponse<CharacterModel>>,
//                    response: Response<RickyAndMortyResponse<CharacterModel>>,
//                ) {
//                    data.value = response.body()
//                }
//
//                override fun onFailure(
//                    call: Call<RickyAndMortyResponse<CharacterModel>>,
//                    t: Throwable,
//                ) {
//                    data.value = null
//                }
//            })
        return data
    }

}



