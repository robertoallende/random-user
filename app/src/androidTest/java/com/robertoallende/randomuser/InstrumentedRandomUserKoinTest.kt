package com.robertoallende.randomuser

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockWebServer
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.mock.declareMock
import retrofit2.Retrofit

abstract class InstrumentedRandomUserKoinTest : KoinTest {

    val overrideTestModule = module(override = true) {
        single<RadomUserIdlingResource> { declareMock() }

        single {
            Interceptor { chain -> chain.proceed(chain.request()) }
        }

        single { MockWebServer() }
        single<Retrofit> {
            Retrofit.Builder()
                .addConverterFactory(get())
                .client(get<OkHttpClient>())
                .baseUrl(get<MockWebServer>().url("/"))
                .build()
        }
    }
}