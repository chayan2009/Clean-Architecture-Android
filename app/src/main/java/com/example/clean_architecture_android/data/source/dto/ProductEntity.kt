package com.example.clean_architecture_android.data.source.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.clean_architecture_android.domain.model.Dimensions
import com.example.clean_architecture_android.domain.model.Meta
import com.example.clean_architecture_android.domain.model.Review

@Entity(tableName = "products_table")
data class ProductEntity(
    @PrimaryKey val id: Int = 0,
    val availabilityStatus: String = "",
    val brand: String = "",
    val category: String = "",
    val description: String = "",
    val dimensions: Dimensions? = null,
    val discountPercentage: Double = 0.0,
    val images: List<String> = emptyList(),
    val meta: Meta? = null,
    val minimumOrderQuantity: Int = 0,
    val price: Double = 0.0,
    val rating: Double = 0.0,
    val returnPolicy: String = "",
    val reviews: List<Review> = emptyList(),
    val shippingInformation: String = "",
    val sku: String = "",
    val stock: Int = 0,
    val tags: List<String> = emptyList(),
    val thumbnail: String = "",
    val title: String = "",
    val warrantyInformation: String = "",
    val weight: Int = 0
)
