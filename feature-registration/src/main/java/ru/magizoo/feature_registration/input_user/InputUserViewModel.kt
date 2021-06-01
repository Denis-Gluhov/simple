package ru.magizoo.feature_registration.input_user

import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.magizoo.core.ui.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class InputUserViewModel @Inject constructor(
//    private val userRepository: UserRepository,
    private val inputUserNavigator: InputUserNavigator
): BaseViewModel() {

    val isValidInputData = MutableLiveData(true)

    private var firstName: String = ""
    private var name: String = ""
    private var secondName: String = ""

    fun changedFirstName(text: String) {
        firstName = text.trim()
        checkInputData()
    }

    fun changedName(text: String) {
        name = text.trim()
        checkInputData()
    }

    fun changedSecondName(text: String) {
        secondName = text.trim()
//        checkInputData()
    }

    private fun checkInputData() {
        isValidInputData.value = firstName.isNotEmpty() && firstName.length >= 3 && name.isNotEmpty() && name.length >= 3
    }

    fun sendUserData() {
        if (isValidInputData.value == true) {
//            disposables += userRepository.setUser(firstName, name, secondName)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe ({
//                    val b = 1
//                }) {
//                    val a = it
//                }
        }
    }

    fun navigateToInputLocation() {
        inputUserNavigator.navigateToInputLocation()
    }

}