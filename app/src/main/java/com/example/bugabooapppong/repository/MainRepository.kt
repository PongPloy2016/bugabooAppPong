package com.example.bugabooapppong.repository


import com.example.bugabooapppong.data.remote.ApiService
import com.example.bugabooapppong.data.remote.RemoteDataSource


class MainRepository(private val remoteDataSource: RemoteDataSource) {
    suspend fun repoGetListUsers() = remoteDataSource.getReceipes()
}