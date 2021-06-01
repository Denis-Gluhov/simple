package ru.magizoo.magizoo.data.catalog

import io.reactivex.Single
import ru.magizoo.magizoo.data.NetworkApi
import ru.magizoo.magizoo.data.model.Category
import ru.magizoo.magizoo.data.model.Product
import javax.inject.Inject

class CatalogRepositoryImp @Inject constructor(
    private val api: NetworkApi
): CatalogRepository {

    override fun getCategories(): Single<List<Category>> {
        return api.getCategory()
            .flatMap {
                if (it.result.isNotEmpty()) {
                    Single.just(it.result)
                } else {
                    Single.error(it.errors[0])
                }
            }
    }

    override fun getSubCategory(parentSection: String, depthLimit: String): Single<List<Category>> {
        return api.getSections(parentSection, depthLimit)
            .flatMap {
                if (it.result.isNotEmpty()) {
                    Single.just(it.result)
                } else {
                    Single.error(it.errors[0])
                }
            }
    }

    override fun getProductList(parentSection: String, sortBy: String): Single<List<Product>> {
        return api.getProductList(parentSection, sortBy)
            .flatMap {
                if (it.result.isNotEmpty()) {
                    Single.just(it.result)
                } else {
                    Single.error(it.errors[0])
                }
            }
    }
}