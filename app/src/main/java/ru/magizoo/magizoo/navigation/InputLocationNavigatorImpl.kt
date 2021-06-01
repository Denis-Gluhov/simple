package ru.magizoo.magizoo.navigation

import androidx.navigation.NavController
import ru.magizoo.feature_registration.input_location.InputLocationFragmentDirections
import ru.magizoo.feature_registration.input_location.InputLocationNavigator

class InputLocationNavigatorImpl : InputLocationNavigator {

    override fun navigateToHome() {
        navController?.navigate(InputLocationFragmentDirections.actionInputCityFragmentToHomeFragment())
    }

    override var navController: NavController? = null

}