package com.example.clean_architecture_android.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.clean_architecture_android.core.common.Converters
import com.example.clean_architecture_android.data.db.ProductDao
import com.example.clean_architecture_android.data.source.dto.MasterEntity
import com.example.clean_architecture_android.data.source.dto.ProductEntity

@Database(entities = [MasterEntity::class,ProductEntity::class], version = 4, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
}
