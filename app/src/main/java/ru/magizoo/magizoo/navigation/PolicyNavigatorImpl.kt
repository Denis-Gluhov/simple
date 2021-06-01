package ru.magizoo.magizoo.navigation

import androidx.navigation.NavController
import ru.magizoo.feature_policy.presentation.PolicyNavigator

class PolicyNavigatorImpl : PolicyNavigator {

    override fun navigateToBack() {
        navController?.popBackStack()
    }

    override var navController: NavController? = null
}