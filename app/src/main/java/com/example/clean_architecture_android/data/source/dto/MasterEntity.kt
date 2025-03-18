package com.example.clean_architecture_android.data.source.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.clean_architecture_android.core.common.ProductListConverter

@Entity(tableName = "master_table")
@TypeConverters(ProductListConverter::class)
data class MasterEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val limit: Int,
    val skip: Int,
    val total: Int,
    val products: List<ProductEntity>
)







