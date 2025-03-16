package com.example.clean_architecture_android.core.common

import com.example.clean_architecture_android.data.source.dto.ProductEntity
import com.example.clean_architecture_android.domain.model.Product

object ProductMapper {

    fun entityToDomain(entity: ProductEntity): Product {
        return Product(
            id = entity.id,
            title = entity.title,
            price = entity.price,
            category = entity.category,
            description = entity.description,
            image = entity.image,
            rating = entity.rating
        )
    }

    fun domainToEntity(product: Product): ProductEntity {
        return ProductEntity(
            id = product.id,
            title = product.title,
            price = product.price,
            category = product.category,
            description = product.description,
            image = product.image,
            rating = product.rating
        )
    }

    fun entityListToDomainList(entities: List<ProductEntity>): List<Product> {
        return entities.map { entityToDomain(it) }
    }

    fun domainListToEntityList(products: List<Product>): List<ProductEntity> {
        return products.map { domainToEntity(it) }
    }
}
