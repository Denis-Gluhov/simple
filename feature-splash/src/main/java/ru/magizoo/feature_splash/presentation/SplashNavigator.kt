package ru.magizoo.feature_splash.presentation

import ru.magizoo.core.navigation.NavControllerHolder

interface SplashNavigator: NavControllerHolder {

    fun navigateToTour()

    fun navigateToRegistration()

    fun navigateToHome()

}