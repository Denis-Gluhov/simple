package ru.magizoo.magizoo.data.model

import com.google.gson.annotations.SerializedName

data class Variation(
    @SerializedName("LABEL")
    val label: String,

    @SerializedName("ITEMS")
    val items: List<Item>
)