package com.example.clean_architecture_android.core.common

import com.example.clean_architecture_android.data.source.dto.MasterEntity
import com.example.clean_architecture_android.data.source.dto.ProductEntity
import com.example.clean_architecture_android.domain.model.Dimensions
import com.example.clean_architecture_android.domain.model.Master
import com.example.clean_architecture_android.domain.model.ProductItem

object ProductMapper {

    fun mapToMasterEntity(master: Master): MasterEntity {
        return MasterEntity(
            total = master.total,
            limit = master.limit,
            skip = master.skip,
            products = master.products.map { it.toEntity() }
        )
    }

    fun mapToDomain(masterEntity: MasterEntity): Master {
        return Master(
            total = masterEntity.total,
            limit = masterEntity.limit,
            skip = masterEntity.skip,
            products = masterEntity.products.map { it.toDomain() }
        )
    }

    private fun ProductItem.toEntity(): ProductEntity {
        return ProductEntity(
            id = id,
            availabilityStatus = availabilityStatus ?: "",
            brand = brand ?: "",
            category = category ?: "",
            description = description ?: "",
            dimensions = dimensions,
            discountPercentage = discountPercentage ?: 0.0,
            images = images ?: emptyList(),
            minimumOrderQuantity = minimumOrderQuantity ?: 0,
            price = price ?: 0.0,
            rating = rating ?: 0.0,
            returnPolicy = returnPolicy ?: "",
            reviews = reviews ?: emptyList(),
            shippingInformation = shippingInformation ?: "",
            sku = sku ?: "",
            stock = stock ?: 0,
            tags = tags ?: emptyList(),
            thumbnail = thumbnail ?: "",
            title = title ?: "",
            warrantyInformation = warrantyInformation ?: "",
            weight = weight ?: 0
        )
    }

    private fun ProductEntity.toDomain(): ProductItem {
        return ProductItem(
            id = id,
            availabilityStatus = availabilityStatus,
            brand = brand,
            category = category,
            description = description,
            dimensions = dimensions ?: Dimensions(0.0, 0.0, 0.0), // Provide a default value
            discountPercentage = discountPercentage,
            images = images,
            minimumOrderQuantity = minimumOrderQuantity,
            price = price,
            rating = rating,
            returnPolicy = returnPolicy,
            reviews = reviews,
            shippingInformation = shippingInformation,
            sku = sku,
            stock = stock,
            tags = tags,
            thumbnail = thumbnail,
            title = title,
            warrantyInformation = warrantyInformation,
            weight = weight,
            meta = TODO()
        )
    }
}
