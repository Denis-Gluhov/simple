package ru.magizoo.feature_home.presentation

data class ItemAction(
    val id: String,
    val title: String,
    val rating: Float,
    val name: String,
    val date: String,
    val oldPrice: Int?,
    val price: Int,
    val picture: String
)