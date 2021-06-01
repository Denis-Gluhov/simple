package ru.magizoo.magizoo.di.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import ru.magizoo.magizoo.data.banner.BannerRepository
import ru.magizoo.magizoo.data.banner.BannerRepositoryImp

@Module
@InstallIn(ViewModelComponent::class)
abstract class BannerDataSourceModule {

    @ViewModelScoped
    @Binds
    abstract fun bindBannerRepository(repository: BannerRepositoryImp): BannerRepository

}