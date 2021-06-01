package ru.magizoo.magizoo.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.magizoo.core.navigation.NavControllerHolder
import ru.magizoo.feature_policy.presentation.PolicyNavigator
import ru.magizoo.feature_registration.confirm_phone.ConfirmPhoneNavigator
import ru.magizoo.feature_registration.input_location.InputLocationNavigator
import ru.magizoo.feature_registration.input_phone.InputPhoneNavigator
import ru.magizoo.feature_registration.input_user.InputUserNavigator
import ru.magizoo.feature_splash.presentation.SplashNavigator
import ru.magizoo.feature_tour.presentation.slider.SliderNavigator
import ru.magizoo.feature_tour.presentation.tour.TourNavigator
import ru.magizoo.magizoo.navigation.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NavigationModule {

    @Provides
    @Singleton
    fun provideSplashNavigator(): SplashNavigator = SplashNavigatorImpl()

    @Provides
    @Singleton
    fun provideTourNavigator(): TourNavigator = TourNavigatorImpl()

    @Provides
    @Singleton
    fun provideSliderNavigator(): SliderNavigator = SliderNavigatorImpl()

    @Provides
    @Singleton
    fun provideInputPhoneNavigator(): InputPhoneNavigator = InputPhoneNavigatorImpl()

    @Provides
    @Singleton
    fun provideConfirmPhoneNavigator(): ConfirmPhoneNavigator = ConfirmPhoneNavigatorImpl()

    @Provides
    @Singleton
    fun provideInputUserNavigator(): InputUserNavigator = InputUserNavigatorImpl()

    @Provides
    @Singleton
    fun provideInputLocationNavigator(): InputLocationNavigator = InputLocationNavigatorImpl()

    @Provides
    @Singleton
    fun providePolicyNavigator(): PolicyNavigator = PolicyNavigatorImpl()

    @Provides
    fun provideNavControllerHolders(
        splashNavigator: SplashNavigator,
        tourNavigator: TourNavigator,
        sliderNavigator: SliderNavigator,
        inputPhoneNavigator: InputPhoneNavigator,
        confirmPhoneNavigator: ConfirmPhoneNavigator,
        inputUserNavigator: InputUserNavigator,
        inputLocationNavigator: InputLocationNavigator,
        policyNavigator: PolicyNavigator
    ): Array<NavControllerHolder> =
        arrayOf(
            splashNavigator,
            tourNavigator,
            sliderNavigator,
            inputPhoneNavigator,
            confirmPhoneNavigator,
            inputUserNavigator,
            inputLocationNavigator,
            policyNavigator
        )

}