package com.example.clean_architecture_android.data.source.dto

import com.example.clean_architecture_android.domain.model.Product

data class ProductDto(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val image: String
) {
    fun toDomain(): Product = Product(id, title, price, description, image)
}
