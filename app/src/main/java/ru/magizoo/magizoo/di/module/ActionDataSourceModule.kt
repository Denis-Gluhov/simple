package ru.magizoo.magizoo.di.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import ru.magizoo.magizoo.data.action.ActionRepository
import ru.magizoo.magizoo.data.action.ActionRepositoryImp

@Module
@InstallIn(ViewModelComponent::class)
abstract class ActionDataSourceModule {

    @ViewModelScoped
    @Binds
    abstract fun bindActionRepository(repository: ActionRepositoryImp): ActionRepository

}