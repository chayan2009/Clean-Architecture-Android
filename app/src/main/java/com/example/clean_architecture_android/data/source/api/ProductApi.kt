package com.example.clean_architecture_android.data.source.api

import com.example.clean_architecture_android.domain.model.Master
import retrofit2.http.GET

interface ProductApi {
    @GET("products")
    suspend fun getProducts(): ProductResponse
}

