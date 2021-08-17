package com.example.retrofitreturnhomework.model

import com.google.gson.annotations.SerializedName

data class EpisodeModel(

    @SerializedName("id")
    var id: Int,

    @SerializedName("name")
    var name: String,

    @SerializedName("episode")
    var episode: String,
)
