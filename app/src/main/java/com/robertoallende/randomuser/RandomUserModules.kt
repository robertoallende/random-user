package com.robertoallende.randomuser

import com.readystatesoftware.chuck.ChuckInterceptor
import com.robertoallende.randomuser.api.ApiContract
import com.robertoallende.randomuser.api.ApiService
import com.robertoallende.randomuser.api.RandomUserApi
import com.robertoallende.randomuser.data.RandomUserRepository
import com.robertoallende.randomuser.db.RandomUserLocalCache
import com.robertoallende.randomuser.ui.user_detail.UserDetailViewModel
import com.robertoallende.randomuser.ui.user_list.UserListViewModel
import com.squareup.moshi.Moshi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

val allModules
    get() = listOf(
        dataModule,
        userListViewModel,
        userDetailViewModel
    )

val dataModule = module {

    single<Converter.Factory> { MoshiConverterFactory.create() }

    single<Interceptor> { ChuckInterceptor(androidContext()) }

    single<OkHttpClient> {
        OkHttpClient.Builder()
            .addInterceptor(get())
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
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

    single<RandomUserRepository> {
        val retrofitApiService = get<Retrofit>().create(ApiService::class.java)
        val localCache = RandomUserLocalCache()
        RandomUserRepository(retrofitApiService, localCache)
    }
}

val userListViewModel = module {
    viewModel { UserListViewModel(get()) }
}

val userDetailViewModel = module {
    viewModel { UserDetailViewModel(get()) }
}