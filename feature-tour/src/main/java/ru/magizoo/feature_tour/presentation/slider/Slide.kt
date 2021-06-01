package ru.magizoo.feature_tour.presentation.slider

import androidx.annotation.DrawableRes

class Slide(@DrawableRes val picture: Int, val title: Int, val body: Int, val type: SlideType = SlideType.NONE, val action: Int)

enum class SlideType {
    NONE,
    LOCATION_PERMISSION
}