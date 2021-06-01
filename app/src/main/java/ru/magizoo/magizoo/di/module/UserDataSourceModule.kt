package ru.magizoo.magizoo.di.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import ru.magizoo.magizoo.data.user.UserRepository
import ru.magizoo.magizoo.data.user.UserRepositoryImp

@Module
@InstallIn(ViewModelComponent::class)
abstract class UserDataSourceModule {

    @ViewModelScoped
    @Binds
    abstract fun bindUserRepository(repository: UserRepositoryImp): UserRepository

}