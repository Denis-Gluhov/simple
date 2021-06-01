package ru.magizoo.magizoo.navigation

import androidx.navigation.NavController
import ru.magizoo.feature_registration.confirm_phone.ConfirmPhoneFragmentDirections
import ru.magizoo.feature_registration.confirm_phone.ConfirmPhoneNavigator

class ConfirmPhoneNavigatorImpl : ConfirmPhoneNavigator {

    override fun navigateToInputUser() {
        navController?.navigate(ConfirmPhoneFragmentDirections.actionConfirmPhoneFragmentToInputUserFragment())
    }

    override fun navigateToBack() {
        navController?.popBackStack()
    }

    override var navController: NavController? = null
}