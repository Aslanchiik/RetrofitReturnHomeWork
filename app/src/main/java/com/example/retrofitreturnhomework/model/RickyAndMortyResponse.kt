package com.example.retrofitreturnhomework.model

import com.google.gson.annotations.SerializedName
import java.util.ArrayList

data class RickyAndMortyResponse <T>(

    @SerializedName("info")
      val info : Info,

    @SerializedName("results")
    var results: ArrayList<T>
)

