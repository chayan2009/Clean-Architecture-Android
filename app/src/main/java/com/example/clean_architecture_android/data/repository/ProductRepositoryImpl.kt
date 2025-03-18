package com.example.clean_architecture_android.data.repository

import com.example.clean_architecture_android.data.db.ProductDao
import com.example.clean_architecture_android.data.source.api.ProductApi
import com.example.clean_architecture_android.data.source.api.ProductResponse
import com.example.clean_architecture_android.data.source.dto.ProductEntity
import com.example.clean_architecture_android.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val api: ProductApi,
    private val productDao: ProductDao
) : ProductRepository {

    override suspend fun getProducts(): Flow<List<ProductEntity>> = flow {
        val cachedProducts = productDao.getProducts().firstOrNull()

        if (!cachedProducts.isNullOrEmpty()) {
            println("Returning cached products: ${cachedProducts.size}")
            emit(cachedProducts)
        } else {
            println("No cached products found, fetching from API...")

            try {
                val response: ProductResponse = api.getProducts()
                val productList = response.products

                if (productList.isNotEmpty()) {
                    println("API Response size: ${productList.size}")

                    productDao.insertProducts(productList)

                    emit(productList)
                } else {
                    println("API returned an empty product list")
                    emit(emptyList())
                }
            } catch (e: Exception) {
                e.printStackTrace()
                throw Exception("Error fetching products: ${e.localizedMessage}")
            }
        }
    }
}
