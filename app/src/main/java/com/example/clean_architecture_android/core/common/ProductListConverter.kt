package com.example.clean_architecture_android.core.common
import androidx.room.TypeConverter
import com.example.clean_architecture_android.data.source.dto.ProductEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ProductListConverter {
    private val gson = Gson()

    @TypeConverter
    fun fromProductList(products: List<ProductEntity>?): String {
        return gson.toJson(products)
    }

    @TypeConverter
    fun toProductList(productsJson: String?): List<ProductEntity> {
        if (productsJson.isNullOrEmpty()) return emptyList()
        val type = object : TypeToken<List<ProductEntity>>() {}.type
        return gson.fromJson(productsJson, type)
    }
}
