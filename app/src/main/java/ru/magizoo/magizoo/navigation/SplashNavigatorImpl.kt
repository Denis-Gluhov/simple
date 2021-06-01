package ru.magizoo.magizoo.navigation

import androidx.navigation.NavController
import ru.magizoo.feature_splash.presentation.SplashFragmentDirections

class SplashNavigatorImpl : ru.magizoo.feature_splash.presentation.SplashNavigator {

    override fun navigateToRegistration() {
        navController?.navigate(SplashFragmentDirections.actionSplashFragmentToInputPhoneFragment())
    }

    override fun navigateToHome() {
        navController?.navigate(SplashFragmentDirections.actionSplashFragmentToHomeFragment())
    }

    override fun navigateToTour() {
        navController?.navigate(SplashFragmentDirections.actionSplashFragmentToTourFragment())
    }

    override var navController: NavController? = null
}