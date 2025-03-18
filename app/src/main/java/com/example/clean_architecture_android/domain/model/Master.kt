package com.example.clean_architecture_android.domain.model

data class Master(
    val limit: Int,
    val products: List<ProductItem>,
    val skip: Int,
    val total: Int
)