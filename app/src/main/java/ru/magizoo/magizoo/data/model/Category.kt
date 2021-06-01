package ru.magizoo.magizoo.data.model

import com.google.gson.annotations.SerializedName

data class Category(

    @SerializedName("ID")
    val id: String,

    @SerializedName("NAME")
    val name: String,

    @SerializedName("LINK")
    val link: String,

    @SerializedName("PICTURE")
    val picture: String,

    @SerializedName("DEPTH_LEVEL")
    val depthLevel: String,

    @SerializedName("PARENT_SECTION_ID")
    val parentSectionId: String?,

    @SerializedName("COUNT_ELEMENTS")
    val countElements: String

)