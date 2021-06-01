package ru.magizoo.feature_registration.confirm_phone

import ru.magizoo.core.navigation.NavControllerHolder

interface ConfirmPhoneNavigator : NavControllerHolder {

    fun navigateToInputUser()

    fun navigateToBack()

}