package ru.magizoo.magizoo.navigation

import androidx.navigation.NavController
import ru.magizoo.feature_registration.input_phone.InputPhoneFragmentDirections
import ru.magizoo.feature_registration.input_phone.InputPhoneNavigator

class InputPhoneNavigatorImpl : InputPhoneNavigator {

    override fun navigateToPrivacyPolicy() {
        navController?.navigate(InputPhoneFragmentDirections.actionInputPhoneFragmentToPrivacyPolicyFragment())
    }

    override fun navigateToConfirmPhone(phone: String) {
        navController?.navigate(InputPhoneFragmentDirections.actionInputPhoneFragmentToConfirmPhoneFragment(phone))
    }

    override var navController: NavController? = null
}