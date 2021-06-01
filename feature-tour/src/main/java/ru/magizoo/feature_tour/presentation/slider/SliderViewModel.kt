package ru.magizoo.feature_tour.presentation.slider

import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.magizoo.core.ui.BaseViewModel
import ru.magizoo.feature_tour.R
import javax.inject.Inject

@HiltViewModel
class SliderViewModel @Inject constructor(
    private val navigator: SliderNavigator
) : BaseViewModel() {

    val slidePosition = MutableLiveData<Int>()
    var currentPosition = 0

    val slides = listOf(
        Slide(
            picture = R.drawable.picture_location,
            title = R.string.slide_location_title,
            body = R.string.slide_location_body,
            action = R.string.slide_action_grant_permission,
            type = SlideType.LOCATION_PERMISSION
        ),
        Slide(
            picture = R.drawable.picture_sale,
            title = R.string.slide_sale_title,
            body = R.string.slide_sale_body,
            action = R.string.slide_action_next
        ),
        Slide(
            picture = R.drawable.picture_notification,
            title = R.string.slide_notification_title,
            body = R.string.slide_notification_body,
            action = R.string.slide_action_next
        ),
        Slide(
            picture = R.drawable.picture_delivery,
            title = R.string.slide_delivery_title,
            body = R.string.slide_delivery_body,
            action = R.string.slide_action_next
        ),
        Slide(
            picture = R.drawable.picture_discounts,
            title = R.string.slide_discounts_title,
            body = R.string.slide_discounts_body,
            action = R.string.slide_action_begin
        )
    )

    fun clickAction(slide: Slide) {
        when(slide.type) {
            SlideType.LOCATION_PERMISSION -> { /***/ }
            else -> {
                nextSlide()
            }
        }
    }

    private fun nextSlide() {
        if (currentPosition == slides.size - 1) {
            navigateToRegistration()
        } else {
            currentPosition += 1
            slidePosition.value = currentPosition
        }
    }

    fun navigateToRegistration() {
        navigator.navigateToRegistration()
    }

}