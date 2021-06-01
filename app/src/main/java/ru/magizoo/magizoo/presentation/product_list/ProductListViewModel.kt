package ru.magizoo.magizoo.presentation.product_list

import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.magizoo.magizoo.data.catalog.CatalogRepository
import ru.magizoo.magizoo.data.model.Product
import ru.magizoo.magizoo.data.model.Variation
import ru.magizoo.core.ui.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val catalogRepository: CatalogRepository
): BaseViewModel() {

    val products = MutableLiveData<List<ItemProduct>>()

    fun loadProducts(sectionId: String) {
        loading.postValue(true)
        disposables += catalogRepository.getProductList(sectionId, sortBy = "POPULAR")
            .map { mapToList(it) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                loading.postValue(false)
                products.postValue(it)
            }) {
                loading.postValue(false)
                val error = it
            }
    }

    private fun mapToList(items: List<Product>): List<ItemProduct> {
        val data = ArrayList<ItemProduct>(items.size)
        items.forEach {
            data.add(
                ItemProduct(
                    id = it.id,
                    name = it.name,
                    picture = it.previewPicture,
                    variants = mapToVariants(it.variations),
                    rating = it.rating
            ))
        }
        return data
    }

    private fun mapToVariants(items: List<Variation>): List<ItemVariant> {
        val data = ArrayList<ItemVariant>()
        items.forEach { variant ->
            variant.items.forEach {
                data.add(
                    ItemVariant(
                        smallName = it.smallName ?: variant.label,
                        price = it.price
                ))
            }
        }
        return data
    }
}