package com.example.retrofitreturnhomework

import android.app.Application
import com.example.retrofitreturnhomework.data.network.RetrofitClient
import com.example.retrofitreturnhomework.data.network.apiservice.CharacterApiService

 class App : Application () {

      var characterApiService : CharacterApiService? = null


     override fun onCreate() {
        super.onCreate()
         characterApiService = RetrofitClient().providerApiService()

    }

}