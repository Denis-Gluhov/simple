package ru.magizoo.feature_registration.confirm_phone

import android.view.View
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.magizoo.core.ui.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class ConfirmPhoneViewModel @Inject constructor(
//    private val regRepository: RegRepository,
    private val confirmPhoneNavigator: ConfirmPhoneNavigator
): BaseViewModel() {

    val visibleErrorPinCode = MutableLiveData(View.INVISIBLE)

    fun confirm(phone: String, pin: String) {
//        visibleErrorPinCode.value = View.INVISIBLE
//        val number = phone.filter { it.isDigit() }
//        disposables += regRepository.confirm(number, pin)
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({ confirmPhoneNavigator.navigateToInputUser() })
//            {
//                if (it is Error) {
//                    if (it.code == "WRONG_CODE")
//                        visibleErrorPinCode.value = View.VISIBLE
//                }
//            }
    }

    fun navigateToBack() {
        confirmPhoneNavigator.navigateToBack()
    }

}