package ru.magizoo.magizoo.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped
import dagger.multibindings.IntoMap
import ru.magizoo.magizoo.di.scope.ViewModelKey
import ru.magizoo.feature_splash.presentation.SplashViewModel

@Module
@InstallIn(FragmentComponent::class)
abstract class SplashModule {

    @Binds
    @FragmentScoped
    @IntoMap
    @ViewModelKey(ru.magizoo.feature_splash.presentation.SplashViewModel::class)
    abstract fun bindSplashViewModel(viewModel: ru.magizoo.feature_splash.presentation.SplashViewModel) : ViewModel

}