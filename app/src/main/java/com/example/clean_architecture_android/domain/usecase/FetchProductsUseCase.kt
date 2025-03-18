package com.example.clean_architecture_android.domain.usecase

import com.example.clean_architecture_android.data.source.dto.ProductEntity
import com.example.clean_architecture_android.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchProductsUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(): Flow<List<ProductEntity>> = repository.getProducts()
}
