package ru.magizoo.magizoo.data.auth

import io.reactivex.Single

interface AuthRepository {

    fun isAuthUser(): Single<Boolean>

}