package com.example.clean_architecture_android.domain.repository

import com.example.clean_architecture_android.data.source.dto.ProductEntity
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    suspend fun getProducts():Flow<List<ProductEntity>>
}
