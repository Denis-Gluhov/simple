package ru.magizoo.magizoo.data.model

import com.google.gson.annotations.SerializedName

data class Location(

    @SerializedName("ID")
    val id: String,

    @SerializedName("NAME")
    val name: String,

    @SerializedName("REGION_NAME")
    val regionName: String,

    @SerializedName("COUNTRY_NAME")
    val countryName: String

)
