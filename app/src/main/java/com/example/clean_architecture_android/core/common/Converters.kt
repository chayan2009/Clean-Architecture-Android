package com.example.clean_architecture_android.core.common

import androidx.room.TypeConverter
import com.example.clean_architecture_android.domain.model.Dimensions
import com.example.clean_architecture_android.domain.model.Meta
import com.example.clean_architecture_android.domain.model.Review
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    private val gson = Gson()

    @TypeConverter
    fun fromDimensions(dimensions: Dimensions): String {
        return gson.toJson(dimensions)
    }

    @TypeConverter
    fun toDimensions(dimensionsJson: String): Dimensions {
        return gson.fromJson(dimensionsJson, Dimensions::class.java)
    }

    @TypeConverter
    fun fromMeta(meta: Meta): String {
        return gson.toJson(meta)
    }

    @TypeConverter
    fun toMeta(metaJson: String): Meta {
        return gson.fromJson(metaJson, Meta::class.java)
    }

    @TypeConverter
    fun fromReviewList(reviewList: List<Review>): String {
        return gson.toJson(reviewList)
    }

    @TypeConverter
    fun toReviewList(reviewJson: String): List<Review> {
        val listType = object : TypeToken<List<Review>>() {}.type
        return gson.fromJson(reviewJson, listType)
    }

    @TypeConverter
    fun fromStringList(list: List<String>): String {
        return gson.toJson(list)
    }

    @TypeConverter
    fun toStringList(json: String): List<String> {
        val listType = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(json, listType)
    }
}
