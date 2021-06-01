package ru.magizoo.magizoo.data.model

import com.google.gson.annotations.SerializedName

data class Action(
    @SerializedName("ID")
    val id: String,

    @SerializedName("NAME")
    val name: String,

    @SerializedName("SIZE_ACTION")
    val sizeAction: String,

    @SerializedName("START")
    val start: String,

    @SerializedName("END")
    val end: String,

    @SerializedName("PICTURE_SMALL")
    val pictureSmall: String,

    @SerializedName("PICTURE_BIG")
    val pictureBig: String,

    @SerializedName("ACTION_PRODS")
    val actionProds: List<Product>
)