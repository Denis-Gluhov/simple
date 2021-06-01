package ru.magizoo.magizoo.data.auth

import io.reactivex.Single
import ru.magizoo.magizoo.data.LocalStorage
import javax.inject.Inject

class AuthRepositoryImp @Inject constructor(
    private val localStorage: LocalStorage
): AuthRepository {

    override fun isAuthUser(): Single<Boolean> {
        return localStorage.getToken()
            .map { it.isNotEmpty() }
    }
}