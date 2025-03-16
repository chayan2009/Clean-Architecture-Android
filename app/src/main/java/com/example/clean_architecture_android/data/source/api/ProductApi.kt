package com.example.clean_architecture_android.data.source.api

import com.example.clean_architecture_android.domain.model.Product
import retrofit2.http.GET

interface ProductApi {
    @GET("products")
    suspend fun getProducts(): List<Product>
}
