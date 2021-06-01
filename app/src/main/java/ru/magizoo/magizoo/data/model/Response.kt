package ru.magizoo.magizoo.data.model

import com.google.gson.annotations.SerializedName

data class Response<T>(

    @SerializedName("result")
    val result: List<T>,

    @SerializedName("total")
    val total: Int?,

    @SerializedName("erros")
    val errors: List<Error>

)