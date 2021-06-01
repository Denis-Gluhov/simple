package ru.magizoo.magizoo.di.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import ru.magizoo.magizoo.data.auth.AuthRepository
import ru.magizoo.magizoo.data.auth.AuthRepositoryImp

@Module
@InstallIn(ViewModelComponent::class)
abstract class AuthDataSourceModule {

    @ViewModelScoped
    @Binds
    abstract fun bindAuthRepository(authRepositoryImp: AuthRepositoryImp): AuthRepository

}