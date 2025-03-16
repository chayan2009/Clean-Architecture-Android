package com.example.clean_architecture_android.core.database


import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.clean_architecture_android.core.common.RatingsConverters
import com.example.clean_architecture_android.data.db.ProductDao
import com.example.clean_architecture_android.data.source.dto.ProductEntity

@Database(entities = [ProductEntity::class], version = 8, exportSchema = false)
@TypeConverters(RatingsConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
}
