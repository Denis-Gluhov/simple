package ru.magizoo.magizoo.data

import io.reactivex.Single
import retrofit2.http.*
import ru.magizoo.magizoo.data.model.*

interface NetworkApi {

    @GET("mobile/auth/phone")
    fun reg(@Query("phone") phone: String): Single<Response<Result>>

    @GET("mobile/auth/phone/{phone}")
    fun confirm(
        @Path("phone") phone: String,
        @Query("code") code: String
    ): Single<Response<ResultToken>>

    @PATCH("mobile/personal/fio/")
    fun setUser(
        @Header("Authorization-Token") token: String,
        @Query("name") name: String,
        @Query("last_name") lastName: String
    ): Single<Response<Result>>

    @GET("mobile/personal/locations")
    fun getLocations(@Query("q") query: String): Single<Response<Location>>

    @PATCH("mobile/personal/location/")
    fun setLocation(
        @Header("Authorization-Token") token: String,
        @Query("CITY_ID") locationId: String
    ): Single<Response<Result>>

    @GET("mobile/catalog/get_mainpage_sections")
    fun getCategory(): Single<Response<Category>>

    @GET("/mobile/catalog/getsections/")
    fun getSections(
        @Query("PARENT_SECTION_ID") parentSection: String,
        @Query("DEPTH_LIMIT") depthLimit: String
    ): Single<Response<Category>>

    @GET("/mobile/catalog/get_product_list/")
    fun getProductList(
        @Query("PARENT_SECTION_ID") parentSection: String,
        @Query("SORT_BY") sortBy: String
    ): Single<Response<Product>>

    @GET("mobile/content/topbanner")
    fun getBanners(): Single<Response<Banner>>

    @GET("mobile/content/actionprods")
    fun getActions(
        @Query("discount_type") discountType: String
    ): Single<Response<Action>>

}