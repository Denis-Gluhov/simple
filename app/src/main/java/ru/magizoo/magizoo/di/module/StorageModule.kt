package ru.magizoo.magizoo.di.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.magizoo.magizoo.data.LocalStorage
import ru.magizoo.magizoo.data.LocalStorageImp
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class StorageModule {

    @Singleton
    @Binds
    abstract fun bindLocalStorage(localStorageImp: LocalStorageImp): LocalStorage

}