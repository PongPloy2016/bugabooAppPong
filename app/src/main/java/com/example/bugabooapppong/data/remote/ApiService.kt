package com.example.bugabooapppong.data.remote

import com.example.bugabooapppong.data.model.MainResponse
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {
    @Headers("Accept: application/json")
    @GET("v3/d71db3fe-974a-4c25-bdb2-1d7e94e67afb")
    suspend fun mainList(): MainResponse
}