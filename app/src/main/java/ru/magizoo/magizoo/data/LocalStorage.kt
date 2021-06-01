package ru.magizoo.magizoo.data

import io.reactivex.Completable
import io.reactivex.Single
import ru.magizoo.magizoo.data.model.User

interface LocalStorage {

    fun setToken(token: String): Completable

    fun setPhone(phone: String): Completable

    fun getToken(): Single<String>

}