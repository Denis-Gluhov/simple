package ru.magizoo.feature_tour.presentation.tour

import dagger.hilt.android.lifecycle.HiltViewModel
import ru.magizoo.core.ui.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class TourViewModel @Inject constructor(
    private val navigator: TourNavigator
) : BaseViewModel() {

    fun navigateToSlider() {
        navigator.navigateToSlider()
    }

}