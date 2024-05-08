package com.example.bugabooapppong.di

import com.example.bugabooapppong.repository.MainRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory { MainRepository(get()) }
}