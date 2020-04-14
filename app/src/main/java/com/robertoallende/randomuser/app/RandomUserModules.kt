package com.robertoallende.randomuser.app

import com.readystatesoftware.chuck.ChuckInterceptor
import com.robertoallende.randomuser.BuildConfig
import com.robertoallende.randomuser.data.ApiContract
import com.robertoallende.randomuser.data.ApiService
import com.robertoallende.randomuser.data.RandomUserApi
import com.robertoallende.randomuser.data.RandomUserDataRepository
import com.squareup.moshi.Moshi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

val allModules
    get() = listOf(dataModule)

val dataModule = module {
    
    single<Converter.Factory> { MoshiConverterFactory.create() }

    single<Interceptor> { ChuckInterceptor(androidContext()) }

    single<OkHttpClient> {
        OkHttpClient.Builder()
            .addInterceptor(get())
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .addConverterFactory(get())
            .client(get<OkHttpClient>())
            .baseUrl(BuildConfig.API_URL)
            .build()
    }

    single {
        Moshi.Builder().build()
    }

    single<ApiContract> {
        val retrofitApiService = get<Retrofit>().create(ApiService::class.java)
        RandomUserApi(retrofitApiService)
    }

    single<ApiContract> { RandomUserDataRepository(get()) }
}