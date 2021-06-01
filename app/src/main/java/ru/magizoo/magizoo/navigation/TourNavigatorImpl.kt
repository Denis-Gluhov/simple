package ru.magizoo.magizoo.navigation

import androidx.navigation.NavController
import ru.magizoo.feature_tour.presentation.tour.TourFragmentDirections
import ru.magizoo.feature_tour.presentation.tour.TourNavigator

class TourNavigatorImpl : TourNavigator {

    override fun navigateToSlider() {
        navController?.navigate(TourFragmentDirections.actionTutorialFragmentToSliderFragment())
    }

    override var navController: NavController? = null

}