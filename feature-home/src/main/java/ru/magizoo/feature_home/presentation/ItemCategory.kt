package ru.magizoo.feature_home.presentation

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemCategory(
    val id: String,

    @DrawableRes
    val picture: Int,

    val name: String,

    val count: String = "0"
): Parcelable