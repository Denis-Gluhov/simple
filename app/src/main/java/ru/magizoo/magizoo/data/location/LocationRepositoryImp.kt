package ru.magizoo.magizoo.data.location

import io.reactivex.Single
import ru.magizoo.magizoo.data.NetworkApi
import ru.magizoo.magizoo.data.model.Location
import javax.inject.Inject

class LocationRepositoryImp @Inject constructor(
    private val api: NetworkApi
): LocationRepository {

    override fun getLocations(query: String): Single<List<Location>> {
        return api.getLocations(query)
            .flatMap {
                if (it.errors.isNotEmpty())
                    Single.error(it.errors[0])
                else
                    Single.just(it.result)
            }
    }
}