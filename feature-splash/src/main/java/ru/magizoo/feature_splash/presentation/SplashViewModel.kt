package ru.magizoo.feature_splash.presentation

import dagger.hilt.android.lifecycle.HiltViewModel
import ru.magizoo.core.ui.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
//    private val authRepository: AuthRepository,
    private val navigator: SplashNavigator
) : BaseViewModel() {

    fun loadData() {
        navigator.navigateToHome()
    }

//    fun checkAuthUser() {
//        disposables += authRepository.isAuthUser().delay(2, TimeUnit.SECONDS)
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                if (it) {
//                    splashNavigator.navigateToHome()
//                } else {
//                    splashNavigator.navigateToRegistration()
//                }
//            }) {
//                val s = it
//            }
//    }

}