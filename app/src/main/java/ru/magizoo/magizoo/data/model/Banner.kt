package ru.magizoo.magizoo.data.model

import com.google.gson.annotations.SerializedName

data class Banner(
    @SerializedName("ID")
    val id: String,

    @SerializedName("NAME")
    val name: String,

    @SerializedName("LINK")
    val link: String,

    @SerializedName("PICTURE")
    val picture: String
)