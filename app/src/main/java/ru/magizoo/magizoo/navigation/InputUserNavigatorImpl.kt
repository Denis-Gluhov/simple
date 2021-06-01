package ru.magizoo.magizoo.navigation

import androidx.navigation.NavController
import ru.magizoo.feature_registration.input_user.InputUserFragmentDirections
import ru.magizoo.feature_registration.input_user.InputUserNavigator

class InputUserNavigatorImpl : InputUserNavigator {

    override fun navigateToInputLocation() {
        navController?.navigate(InputUserFragmentDirections.actionInputNameFragmentToInputLocationFragment())
    }

    override fun navigateToHome() {
        navController?.navigate(InputUserFragmentDirections.actionInputNameFragmentToHomeFragment())
    }

    override var navController: NavController? = null
}