package ru.magizoo.magizoo.data.banner

import io.reactivex.Single
import ru.magizoo.magizoo.data.model.Banner

interface BannerRepository {

    fun getBanners(): Single<List<Banner>>

}