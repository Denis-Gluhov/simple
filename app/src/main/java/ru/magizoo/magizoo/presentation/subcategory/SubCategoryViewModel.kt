package ru.magizoo.magizoo.presentation.subcategory

import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.magizoo.magizoo.R
import ru.magizoo.magizoo.data.catalog.CatalogRepository
import ru.magizoo.magizoo.data.model.Category
import ru.magizoo.core.ui.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class SubCategoryViewModel @Inject constructor (
    private val catalogRepository: CatalogRepository
): BaseViewModel() {

    val subCategory = MutableLiveData<List<ItemSubCategory>>()

    fun loadSubCategory(parentSection: String) {
        loading.postValue(true)
        disposables += catalogRepository.getSubCategory(parentSection, depthLimit = "2")
            .map { mapToList(it) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                subCategory.postValue(it)
                loading.postValue(false)
            }) {
                val error = it
                loading.postValue(false)
            }
    }

    private fun mapToList(items: List<Category>): List<ItemSubCategory> {
        val data = ArrayList<ItemSubCategory>(items.size)
        items.forEach { item ->
            data.add(
                ItemSubCategory(
                    id = item.id,
                    name = item.name,
                    parentSection = item.id
            ))
        }
        return data
    }

    fun clickItem() {
//        navigate.postValue(R.id.productListFragment)
    }

}