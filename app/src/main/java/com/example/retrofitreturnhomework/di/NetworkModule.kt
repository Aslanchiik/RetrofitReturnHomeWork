package com.example.retrofitreturnhomework.di

import com.example.retrofitreturnhomework.data.network.RetrofitClient
import com.example.retrofitreturnhomework.data.network.apiservice.CharacterApiService
import com.example.retrofitreturnhomework.data.network.apiservice.EpisodeApiService
import com.example.retrofitreturnhomework.data.network.apiservice.LocationApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn (SingletonComponent::class)
object NetworkModule {

    @Singleton
     val retrofitClient : RetrofitClient = RetrofitClient()

    @Singleton
    @Provides
      fun providers () : CharacterApiService {
          return retrofitClient.providerApiService()

      }

    @Singleton
    @Provides
      fun provideLocation () : LocationApiService {
          return  retrofitClient.providerLocationApiService()
      }

    @Singleton
    @Provides
       fun provideEpisode () : EpisodeApiService {
           return  retrofitClient.providerEpisodeApiService()
       }

}