package ru.magizoo.magizoo.data.catalog

import io.reactivex.Single
import ru.magizoo.magizoo.data.model.Category
import ru.magizoo.magizoo.data.model.Product

interface CatalogRepository {

    fun getCategories(): Single<List<Category>>

    fun getSubCategory(parentSection: String, depthLimit: String): Single<List<Category>>

    fun getProductList(parentSection: String, sortBy: String): Single<List<Product>>

}