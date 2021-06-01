package ru.magizoo.magizoo.navigation

import androidx.navigation.NavController
import ru.magizoo.feature_tour.presentation.slider.SliderFragmentDirections
import ru.magizoo.feature_tour.presentation.slider.SliderNavigator

class SliderNavigatorImpl : SliderNavigator {

    override fun navigateToRegistration() {
        navController?.navigate(SliderFragmentDirections.actionSliderTutorialFragmentToInputPhoneFragment())
    }

    override var navController: NavController? = null

}