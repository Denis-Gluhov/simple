package ru.magizoo.magizoo.di.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import ru.magizoo.magizoo.data.catalog.CatalogRepository
import ru.magizoo.magizoo.data.catalog.CatalogRepositoryImp

@Module
@InstallIn(ViewModelComponent::class)
abstract class CategoryDataSourceModule {

    @ViewModelScoped
    @Binds
    abstract fun bindCategoryRepository(repository: CatalogRepositoryImp): CatalogRepository

}