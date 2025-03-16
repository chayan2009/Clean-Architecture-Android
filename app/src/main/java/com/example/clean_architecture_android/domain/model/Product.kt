package com.example.clean_architecture_android.domain.model

import com.example.clean_architecture_android.data.source.dto.Rating

data class Product(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val category: String,
    val image: String,
    val rating: Rating,
    )
data class Rating(
    val count: Int,
    val rate: Double
)
