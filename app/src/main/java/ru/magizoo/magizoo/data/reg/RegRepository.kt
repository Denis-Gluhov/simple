package ru.magizoo.magizoo.data.reg

import io.reactivex.Completable

interface RegRepository {

    fun registration(phoneNumber: String): Completable

    fun confirm(phoneNumber: String, code: String): Completable

}