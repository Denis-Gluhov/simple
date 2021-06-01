package ru.magizoo.magizoo.data.reg

import io.reactivex.Completable
import ru.magizoo.magizoo.data.LocalStorage
import ru.magizoo.magizoo.data.NetworkApi
import javax.inject.Inject

class RegRepositoryImp @Inject constructor(
    private val api: NetworkApi,
    private val localStorage: LocalStorage
): RegRepository {

    override fun registration(phoneNumber: String): Completable {
        return api.reg(phoneNumber)
            .flatMapCompletable { response ->
                if (response.result.isNotEmpty() && response.result[0].success) {
                    Completable.complete()
                } else {
                    Completable.error(response.errors[0])
                }
            }

    }

    override fun confirm(phoneNumber: String, code: String): Completable {
        return api.confirm(phoneNumber, code)
            .flatMapCompletable { response ->
                if (response.result.isNotEmpty() && response.result[0].success) {
                    localStorage.setToken(response.result[0].apiToken)
                } else {
                    Completable.error(response.errors[0])
                }
            }
    }

}