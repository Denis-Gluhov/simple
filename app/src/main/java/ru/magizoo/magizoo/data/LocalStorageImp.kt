package ru.magizoo.magizoo.data

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class LocalStorageImp @Inject constructor(
    @ApplicationContext context: Context
): LocalStorage {

    private val prefs: SharedPreferences = context.getSharedPreferences(STORAGE_NAME, Context.MODE_PRIVATE)

    override fun setToken(token: String): Completable {
        prefs.edit()
            .putString(TOKEN, token)
            .apply()
        return Completable.complete()
    }

    override fun setPhone(phone: String): Completable {
        prefs.edit()
            .putString(PHONE, phone)
            .apply()
        return Completable.complete()
    }

    override fun getToken(): Single<String> {
        val token = prefs.getString(TOKEN, "")
        return Single.just(token)
    }

    companion object {
        private const val STORAGE_NAME = "storage_name"
        private const val TOKEN = "token"
        private const val PHONE = "phone"
    }

}