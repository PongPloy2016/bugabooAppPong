package com.example.bugabooapppong

import android.app.Application
import com.example.bugabooapppong.di.networkModule
import com.example.bugabooapppong.di.remoteDataSourceModule
import com.example.bugabooapppong.di.repositoryModule
import com.example.bugabooapppong.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication: Application(){

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            androidLogger(Level.ERROR)
            modules(remoteDataSourceModule, repositoryModule, networkModule, viewModelModule)
        }
    }
}