package com.example.bugabooapppong.di


import com.example.bugabooapppong.data.remote.ApiService
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


fun provideHttpClient(): OkHttpClient {
    return OkHttpClient
        .Builder()
        .readTimeout(60, TimeUnit.SECONDS)
        .connectTimeout(60, TimeUnit.SECONDS)
        .build()
}


fun provideConverterFactory(): GsonConverterFactory =
    GsonConverterFactory.create()


fun provideRetrofit(
    okHttpClient: OkHttpClient,
    gsonConverterFactory: GsonConverterFactory
): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://run.mocky.io")
        .client(okHttpClient)
        .addConverterFactory(gsonConverterFactory)
        .build()
}

fun provideService(retrofit: Retrofit): ApiService =
    retrofit.create(ApiService::class.java)


val networkModule= module {
    single { provideHttpClient() }
    single { provideConverterFactory() }
    single { provideRetrofit(get(),get()) }
    single { provideService(get()) }
}


//
//import com.google.gson.GsonBuilder
//import org.koin.android.BuildConfig
//import okhttp3.Cache
//import okhttp3.Interceptor
//import okhttp3.OkHttpClient
//import okhttp3.logging.HttpLoggingInterceptor
//import org.koin.android.ext.koin.androidApplication
//import org.koin.core.scope.Scope
//import org.koin.dsl.module
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import java.util.concurrent.TimeUnit
//
//private const val CONNECT_TIMEOUT = 15L
//private const val WRITE_TIMEOUT = 15L
//private const val READ_TIMEOUT = 15L
//val RetrofitModule = module {
//    single { Cache(androidApplication().cacheDir, 10L * 1024 * 1024) }
//    single { GsonBuilder().create() }
//    single { retrofitHttpClient() }
//    single { retrofitBuilder() }
//    single {
//        Interceptor { chain ->
//            chain.proceed(chain.request().newBuilder().apply {
//                header("Accept", "application/json")
//            }.build())
//        }
//    }
//}
//
//private fun Scope.retrofitBuilder(): Retrofit {
//    return Retrofit.Builder()
//        .baseUrl("https://run.mocky.io")
//        .addConverterFactory(GsonConverterFactory.create(get()))
//        //.addCallAdapterFactory(RxJava2CallAdapterFactory.create()) krn sudah pakai --> Coroutines
//        .client(get())
//        .build()
//}
//
//
//private fun Scope.retrofitHttpClient(): OkHttpClient {
//    return OkHttpClient.Builder().apply {
//        cache(get())
//        connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
//        writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
//        readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
//        retryOnConnectionFailure(true)
//        addInterceptor(get())
//        addInterceptor(HttpLoggingInterceptor().apply {
//            level = if (BuildConfig.DEBUG) {
//                HttpLoggingInterceptor.Level.HEADERS
//            }
//            else {
//                HttpLoggingInterceptor.Level.NONE
//            }
//        })
//    }.build()
//}