package com.example.clean_architecture_android.data.source.dto
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Product")
data class ProductEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val category: String,
    val image: String,
    val rating: Rating

    )
data class Rating(
    val count: Int,
    val rate: Double
)




