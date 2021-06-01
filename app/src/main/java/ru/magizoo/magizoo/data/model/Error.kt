package ru.magizoo.magizoo.data.model

import com.google.gson.annotations.SerializedName

data class Error(

    @SerializedName("CODE")
    val code: String,

    @SerializedName("TXT")
    override val message: String

): Throwable()