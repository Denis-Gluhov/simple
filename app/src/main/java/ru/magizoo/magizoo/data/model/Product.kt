package ru.magizoo.magizoo.data.model

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("ID")
    val id: String,

    @SerializedName("NAME")
    val name: String,

    @SerializedName("PREVIEW_PICTURE")
    val previewPicture: String?,

    @SerializedName("DETAIL_PICTURE")
    val detailPicture: String,

    @SerializedName("RATING")
    val rating: Float,

    @SerializedName("VOTES")
    val votes: Int,

    @SerializedName("FLAGS")
    val flags: List<String>,

    @SerializedName("IF_FAVORITE")
    val isFavorite: Boolean,

    @SerializedName("PREVIEW_TEXT")
    val previewText: String,

    @SerializedName("PRICE")
    val price: Int,

    @SerializedName("OLD_PRICE")
    val oldPrice: Int?,

    @SerializedName("VARIATION")
    val variations: List<Variation>
)