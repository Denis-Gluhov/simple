package ru.magizoo.feature_registration.input_phone

import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.magizoo.core.ui.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class InputPhoneViewModel @Inject constructor(
//    private val regRepository: RegRepository,
    private val navigator: InputPhoneNavigator
): BaseViewModel() {

    val isValidPhoneNumber = MutableLiveData(false)

    private var phoneNumber: String = ""

    fun validatePhoneNumber(input: String) {
        val result = input.filter { it.isDigit() }
        if (result.length == 11) {
            phoneNumber = result
            isValidPhoneNumber.value = true
        } else
            isValidPhoneNumber.value = false
    }

    fun registration() {
        navigator.navigateToConfirmPhone("89094515463")
//        if (isValidPhoneNumber.value == true) {
//            disposables += regRepository.registration(phoneNumber)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({ inputPhoneNavigator.navigateToConfirmPhone(phoneNumber) })
//                {
//                    val s = it
//                }
//        }
    }

    fun navigateToPrivacyPolicy() {
        navigator.navigateToPrivacyPolicy()
    }

}