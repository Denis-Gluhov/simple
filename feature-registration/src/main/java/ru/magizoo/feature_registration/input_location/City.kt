package ru.magizoo.feature_registration.input_location

data class City(
    val id: String,
    val name: String,
    var isSelected: Boolean = false
)