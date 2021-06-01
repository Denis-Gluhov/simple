package ru.magizoo.magizoo.data.location

import io.reactivex.Single
import ru.magizoo.magizoo.data.model.Location

interface LocationRepository {

    fun getLocations(query: String): Single<List<Location>>

}