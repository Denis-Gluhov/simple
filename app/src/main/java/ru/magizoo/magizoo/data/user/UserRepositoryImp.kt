package ru.magizoo.magizoo.data.user

import io.reactivex.Completable
import ru.magizoo.magizoo.data.LocalStorage
import ru.magizoo.magizoo.data.NetworkApi
import javax.inject.Inject

class UserRepositoryImp @Inject constructor(
    private val localStorage: LocalStorage,
    private val api: NetworkApi
): UserRepository {

    override fun setUser(firstName: String, name: String, lastName: String): Completable {
        return localStorage.getToken()
            .flatMap {
                val token = it
                api.setUser(token, name, firstName)
            }
            .flatMapCompletable {
                if (it.result.isNotEmpty()) {
                    Completable.complete()
                } else {
                    Completable.error(it.errors[0])
                }
            }
    }

    override fun setLocation(cityId: String): Completable {
        return localStorage.getToken()
            .flatMap {
                val token = it
                api.setLocation(token, cityId)
            }
            .flatMapCompletable {
                if (it.result.isNotEmpty()) {
                    Completable.complete()
                } else {
                    Completable.error(it.errors[0])
                }
            }
    }

    override fun setEmailUser(email: String): Completable {
        TODO("Not yet implemented")
    }

    override fun setPhoneUser(phone: String): Completable {
        TODO("Not yet implemented")
    }

    override fun cancelOrder(orderId: Int): Completable {
        TODO("Not yet implemented")
    }
}