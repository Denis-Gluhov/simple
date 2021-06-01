package ru.magizoo.magizoo.presentation.subcategory

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemSubCategory(
    val id: String,
    val name: String,
    val parentSection: String
): Parcelable