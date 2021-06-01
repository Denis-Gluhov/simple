package ru.magizoo.magizoo.data.model

import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("ID")
    val id: String,

    @SerializedName("SMALL_NAME")
    val smallName: String?,

    @SerializedName("NAME")
    val name: String,

    @SerializedName("PRICE")
    val price: Int

//    @SerializedName("OLD_PRICE")
//    val oldPrice: Int?
)