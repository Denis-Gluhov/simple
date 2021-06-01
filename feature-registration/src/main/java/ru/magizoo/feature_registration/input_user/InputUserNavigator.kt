package ru.magizoo.feature_registration.input_user

import ru.magizoo.core.navigation.NavControllerHolder

interface InputUserNavigator : NavControllerHolder {

    fun navigateToInputLocation()

    fun navigateToHome()

}