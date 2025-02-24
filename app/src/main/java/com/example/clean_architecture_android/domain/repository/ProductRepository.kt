package com.example.clean_architecture_android.domain.repository

import com.example.clean_architecture_android.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    suspend fun getProducts(): Flow<List<Product>>
}
