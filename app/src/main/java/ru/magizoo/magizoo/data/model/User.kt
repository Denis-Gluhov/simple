package ru.magizoo.magizoo.data.model

import com.google.gson.annotations.SerializedName

data class User(

    @SerializedName("name")
    val name: String,

    @SerializedName("last_name")
    val lastName: String,

    @SerializedName("second_name")
    val secondName: String? = null

)
