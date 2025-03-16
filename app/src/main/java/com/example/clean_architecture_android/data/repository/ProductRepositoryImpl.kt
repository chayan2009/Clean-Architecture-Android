package com.example.clean_architecture_android.data.repository


import com.example.clean_architecture_android.core.common.ProductMapper
import com.example.clean_architecture_android.data.db.ProductDao
import com.example.clean_architecture_android.data.source.api.ProductApi
import com.example.clean_architecture_android.domain.model.Product
import com.example.clean_architecture_android.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow

class ProductRepositoryImpl(
    private val api: ProductApi,
    private val productDao: ProductDao
) : ProductRepository {

    override suspend fun getProducts(): Flow<List<Product>> = flow {
        val cachedProducts = productDao.getProducts()
            .firstOrNull()
            ?.let { ProductMapper.entityListToDomainList(it) } ?: emptyList()

        println("Cached Products size: ${cachedProducts.size}")

        if (cachedProducts.isNotEmpty()) {
            emit(cachedProducts)
        } else {
            try {
                val response = api.getProducts()
                println("API Response size: ${response.size}")

                val domainProducts = response
                val entityList = ProductMapper.domainListToEntityList(domainProducts)

                productDao.insertProducts(entityList)
                emit(domainProducts)
            } catch (e: Exception) {
                e.printStackTrace()
                emit(emptyList())
            }
        }
    }
}


