package ru.magizoo.feature_catalog.presentation

import dagger.hilt.android.lifecycle.HiltViewModel
import ru.magizoo.core.ui.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class CatalogViewModel @Inject constructor (
//    private val catalogRepository: CatalogRepository
): BaseViewModel() {

    companion object {
        private const val CATEGORY_DOG = "Собаки"
        private const val CATEGORY_CAT = "Кошки"
        private const val CATEGORY_FISH = "Рыбы"
        private const val CATEGORY_PARROT = "Птицы"
        private const val CATEGORY_RODENT = "Грызуны"
        private const val CATEGORY_FARM = "Фермерам"
        private const val CATEGORY_REPTILE = "Рептилии"
        private const val CATEGORY_FERRET = "Хорьки"
    }

//    val categories = MutableLiveData<List<ItemCategory>>()

    fun loadCategory() {
//        loading.postValue(true)
//        disposables += catalogRepository.getCategories()
//            .map { mapListCategory(it) }
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe ({
//                categories.value = it
//                loading.postValue(false)
//            }) {
//                loading.postValue(false)
//                val error = it
//            }
    }

//    private fun mapListCategory(items: List<Category>): List<ItemCategory> {
//        val data = ArrayList<ItemCategory>(items.size)
//        items.forEach { item ->
//            data.add(
//                ItemCategory(
//                    id = item.id,
//                    name = item.name,
//                    picture = getPicture(item.name)
//                )
//            )
//        }
//        return data
//    }

//    private fun getPicture(nameCategory: String): Int {
//        return when (nameCategory) {
//            CATEGORY_DOG -> R.drawable.picture_dog
//            CATEGORY_CAT -> R.drawable.picture_cat
//            CATEGORY_FISH -> R.drawable.picture_fish
//            CATEGORY_PARROT -> R.drawable.picture_parrot
//            CATEGORY_RODENT -> R.drawable.picture_rodent
//            CATEGORY_FARM -> R.drawable.picture_farm
//            CATEGORY_REPTILE -> R.drawable.picture_reptile
//            CATEGORY_FERRET -> R.drawable.picture_ferret
//            else -> 0
//        }
//    }

    fun clickItem() {
        navigateToSubCategory()
    }

    private fun navigateToSubCategory() {
//        navigate.value = R.id.subCategoryFragment
    }

}