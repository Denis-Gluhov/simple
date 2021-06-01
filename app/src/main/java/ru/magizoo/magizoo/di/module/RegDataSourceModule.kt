package ru.magizoo.magizoo.di.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import ru.magizoo.magizoo.data.reg.RegRepository
import ru.magizoo.magizoo.data.reg.RegRepositoryImp

@Module
@InstallIn(ViewModelComponent::class)
abstract class RegDataSourceModule {

    @ViewModelScoped
    @Binds
    abstract fun bindRegRepository(repositoryImp: RegRepositoryImp): RegRepository

}