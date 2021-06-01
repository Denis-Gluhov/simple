package ru.magizoo.feature_registration.input_phone

import ru.magizoo.core.navigation.NavControllerHolder

interface InputPhoneNavigator : NavControllerHolder {

    fun navigateToPrivacyPolicy()

    fun navigateToConfirmPhone(phone: String)

}