package ru.magizoo.magizoo.data.banner

import io.reactivex.Single
import ru.magizoo.magizoo.data.NetworkApi
import ru.magizoo.magizoo.data.model.Banner
import javax.inject.Inject

class BannerRepositoryImp @Inject constructor(
    private val api: NetworkApi
): BannerRepository {

    override fun getBanners(): Single<List<Banner>> {
        return api.getBanners()
            .flatMap {
                if (it.result.isNotEmpty()) {
                    Single.just(it.result)
                } else {
                    Single.error(it.errors[0])
                }
            }
    }

}