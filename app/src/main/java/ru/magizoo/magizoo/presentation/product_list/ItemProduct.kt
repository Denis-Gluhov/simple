package ru.magizoo.magizoo.presentation.product_list

data class ItemProduct(
    val id: String,
    val name: String,
    val picture: String?,
    val rating: Float,
    val variants: List<ItemVariant>,
    val isFavorite: Boolean = false
)