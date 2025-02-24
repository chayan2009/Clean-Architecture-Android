package com.example.clean_architecture_android.domain.usecase

import com.example.clean_architecture_android.domain.model.Product
import com.example.clean_architecture_android.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow

class GetProductsUseCase(private val repository: ProductRepository) {
    suspend operator fun invoke(): Flow<List<Product>> = repository.getProducts()
}
