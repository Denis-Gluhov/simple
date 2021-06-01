package ru.magizoo.feature_registration.input_location

import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.magizoo.core.ui.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class InputLocationViewModel @Inject constructor(
//    private val locationRepository: LocationRepository,
//    private val userRepository: UserRepository,
    private val inputLocationNavigator: InputLocationNavigator
): BaseViewModel() {

    val cities = MutableLiveData<List<City>>()

    fun loadCities(query: String = "") {
//        loading.value = true
//        disposables += locationRepository.getLocations(query)
//            .map { mapToListCity(it) }
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe ({
//                cities.value = it
//                loading.value = false
//            }) {
//                loading.value = false
//                val error = it
//            }

    }

//    private fun mapToListCity(locations: List<Location>): List<City> {
//        val cities = ArrayList<City>()
//        locations.forEach {
//            cities.add(
//                City(
//                    id = it.id,
//                    name = it.name
//                )
//            )
//        }
//        return cities
//    }

//    fun selectItem(position: Int) {
//        loading.value = true
//        val city = cities.value?.get(position)
//        disposables += userRepository.setLocation(cityId = city!!.id)
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe ({
//                loading.value = false
//                inputLocationNavigator.navigateToHome()
//            }) {
//                loading.value = false
//                val error = it
//            }
//    }
}