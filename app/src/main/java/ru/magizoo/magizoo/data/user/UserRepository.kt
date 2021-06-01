package ru.magizoo.magizoo.data.user

import io.reactivex.Completable
import ru.magizoo.magizoo.data.model.User

interface UserRepository {

    fun setUser(firstName: String, name: String, lastName: String): Completable

    fun setLocation(cityId: String): Completable

    fun setEmailUser(email: String): Completable

    fun setPhoneUser(phone: String): Completable

    fun cancelOrder(orderId: Int): Completable

}