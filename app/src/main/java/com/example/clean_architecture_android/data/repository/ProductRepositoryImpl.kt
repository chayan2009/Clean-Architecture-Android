package com.example.clean_architecture_android.data.repository


import com.example.clean_architecture_android.data.source.api.ProductApi
import com.example.clean_architecture_android.domain.model.Product
import com.example.clean_architecture_android.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val api: ProductApi
) : ProductRepository {

    override suspend fun getProducts(): Flow<List<Product>> = flow {
        try {
            val response = api.getProducts()
            emit(response.map { it.toDomain() }) // Convert DTO to Domain Model
        } catch (e: Exception) {
            emit(emptyList()) // Handle error case
        }
    }

}
