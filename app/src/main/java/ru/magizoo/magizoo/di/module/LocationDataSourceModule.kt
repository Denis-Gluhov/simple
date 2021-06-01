package ru.magizoo.magizoo.di.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import ru.magizoo.magizoo.data.location.LocationRepository
import ru.magizoo.magizoo.data.location.LocationRepositoryImp

@Module
@InstallIn(ViewModelComponent::class)
abstract class LocationDataSourceModule {

    @ViewModelScoped
    @Binds
    abstract fun bindLocationRepository(repository: LocationRepositoryImp): LocationRepository

}