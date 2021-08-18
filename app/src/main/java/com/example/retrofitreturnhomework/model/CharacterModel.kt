package com.example.retrofitreturnhomework.model

import com.example.retrofitreturnhomework.base.BaseInterface
import com.google.gson.annotations.SerializedName

data class CharacterModel (

    @SerializedName("id")
    override var id: Int,

    @SerializedName("name")
    var name: String,

    @SerializedName("image")
    var image: String
        ) : BaseInterface