package ru.magizoo.feature_home.presentation

import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.magizoo.core.ui.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
//    private val catalogRepository: CatalogRepository,
//    private val bannerRepository: BannerRepository,
//    private val actionRepository: ActionRepository
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

    val categories = MutableLiveData<List<ItemCategory>>()
    val banners = MutableLiveData<List<ItemBanner>>()
    val actionsOfWeek = MutableLiveData<List<ItemAction>>()
    val actionsOfOther = MutableLiveData<List<ItemAction>>()

    fun loadCategories() {
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

    fun loadBanners() {
//        loading.postValue(true)
//        disposables += bannerRepository.getBanners()
//            .map { mapListBanner(it) }
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe ({
//                banners.value = it
//                loading.postValue(false)
//            }) {
//                loading.postValue(false)
//                val error = it
//            }
    }

    fun loadActionsOfWeek() {
//        disposables += actionRepository.getActionsOfWeek()
//            .map { mapListActionsOfWeek(it) }
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe ({
//                actionsOfWeek.value = it
//                loading.postValue(false)
//            }) {
//                loading.postValue(false)
//                val error = it
//            }
    }

    fun loadActionsOfOther() {
//        disposables += actionRepository.getActions()
//            .map { mapListActionsOfOther(it) }
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe ({
//                actionsOfOther.value = it
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
//                    count = "${item.countElements} товаров",
//                    picture = getPicture(item.name)
//            ))
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

    fun selectGeneralCategory() {
//        navigate.value = R.id.subCategoryFragment
    }

//    private fun mapListBanner(items: List<Banner>): List<ItemBanner> {
//        val banners = ArrayList<ItemBanner>(items.size)
//        items.forEach { item ->
//            banners.add(
//                ItemBanner(
//                    id = item.id,
//                    link = item.link,
//                    picture = item.picture
//            ))
//        }
//        return banners
//    }

//    private fun mapListActionsOfWeek(items: List<Action>): List<ItemAction> {
//        val data = ArrayList<ItemAction>(items.size)
//        items.forEach { item ->
//            data.add(
//                ItemAction(
//                    id = item.actionProds[0].id,
//                    rating = item.actionProds[0].rating,
//                    name = item.actionProds[0].name,
//                    date = "${item.start} - ${item.end}",
//                    oldPrice = item.actionProds[0].oldPrice,
//                    price = item.actionProds[0].price,
//                    picture = item.actionProds[0].previewPicture ?: "",
//                    title = "Товары недели"
//            ))
//        }
//        return data
//    }

//    private fun mapListActionsOfOther(items: List<Action>): List<ItemAction> {
//        val data = ArrayList<ItemAction>(items.size)
//        items.forEach { item ->
//            data.add(
//                ItemAction(
//                    id = item.actionProds[0].id,
//                    rating = item.actionProds[0].rating,
//                    name = item.actionProds[0].name,
//                    date = "${item.start} - ${item.end}",
//                    oldPrice = item.actionProds[0].oldPrice,
//                    price = item.actionProds[0].price,
//                    picture = item.actionProds[0].previewPicture ?: "",
//                    title = "Товары недели"
//                ))
//        }
//        return data
//    }

}