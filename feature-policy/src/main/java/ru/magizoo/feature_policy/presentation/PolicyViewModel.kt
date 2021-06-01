package ru.magizoo.feature_policy.presentation

import dagger.hilt.android.lifecycle.HiltViewModel
import ru.magizoo.core.ui.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class PolicyViewModel @Inject constructor(
    private val navigator: PolicyNavigator
): BaseViewModel() {

    fun navigateToBack() {
        navigator.navigateToBack()
    }

}