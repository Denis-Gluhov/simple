package ru.magizoo.feature_policy.presentation

import ru.magizoo.core.navigation.NavControllerHolder

interface PolicyNavigator : NavControllerHolder {

    fun navigateToBack()

}