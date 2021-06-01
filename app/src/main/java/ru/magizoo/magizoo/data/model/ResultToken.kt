package ru.magizoo.magizoo.data.model

import com.google.gson.annotations.SerializedName

data class ResultToken(

    @SerializedName("SUCCESS")
    val success: Boolean,

    @SerializedName("API_TOKEN")
    val apiToken: String

)