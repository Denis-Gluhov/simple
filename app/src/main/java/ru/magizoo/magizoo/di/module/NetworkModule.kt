package ru.magizoo.magizoo.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.magizoo.magizoo.data.NetworkApi
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    companion object {
        private const val BASE_URL = "https://spb.magizoo.ru/"
        private const val TIMEOUT_CONNECT: Long = 180
        private const val TIMEOUT_READ: Long = 180
        private const val TIMEOUT_WRITE: Long = 180
    }

    @Singleton
    @Provides
    fun provideNetworkApi(): NetworkApi {
        val retrofit = createRetrofit()
        return retrofit.create(NetworkApi::class.java)
    }

    private fun createRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(createHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    private fun createHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val httpClient = OkHttpClient.Builder()
        httpClient.connectTimeout(TIMEOUT_CONNECT, TimeUnit.SECONDS)
        httpClient.readTimeout(TIMEOUT_READ, TimeUnit.SECONDS)
//        httpClient.hostnameVerifier { _, _ -> true }
        httpClient.addInterceptor(loggingInterceptor)
        return httpClient.build()
    }

}