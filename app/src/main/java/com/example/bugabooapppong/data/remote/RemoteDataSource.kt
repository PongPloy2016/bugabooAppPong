package com.example.bugabooapppong.data.remote

class RemoteDataSource(private val apiService: ApiService) {
    suspend fun getReceipes() = apiService.mainList()
//    suspend fun getReceipesDetail(id:Int?) = apiService.getReceipeDetails(id)
}