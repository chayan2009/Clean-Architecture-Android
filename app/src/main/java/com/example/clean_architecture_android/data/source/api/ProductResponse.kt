package com.example.clean_architecture_android.data.source.api

import com.example.clean_architecture_android.data.source.dto.ProductEntity

data class ProductResponse(
    val products: List<ProductEntity>
)
