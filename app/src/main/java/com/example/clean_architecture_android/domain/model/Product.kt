package com.example.clean_architecture_android.domain.model

data class Product(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val image: String
)
