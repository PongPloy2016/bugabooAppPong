package com.example.bugabooapppong.di

import com.example.bugabooapppong.data.Receipes
import com.example.bugabooapppong.data.remote.RemoteDataSource
import org.koin.dsl.module
import retrofit2.Retrofit

//val apiModule = module {
//    single(createdAtStart = false) { get<Retrofit>().create(Receipes::class.java) }
//}

val remoteDataSourceModule= module {
    factory {  RemoteDataSource(get()) }
}