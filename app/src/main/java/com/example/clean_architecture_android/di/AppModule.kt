package com.example.clean_architecture_android.di

import android.content.Context
import androidx.room.Room
import com.example.clean_architecture_android.core.common.Constants
import com.example.clean_architecture_android.core.database.AppDatabase
import com.example.clean_architecture_android.data.db.ProductDao
import com.example.clean_architecture_android.data.repository.ProductRepositoryImpl
import com.example.clean_architecture_android.data.source.api.ProductApi
import com.example.clean_architecture_android.domain.repository.ProductRepository
import com.example.clean_architecture_android.domain.usecase.FetchProductsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ProductApi =
        retrofit.create(ProductApi::class.java)


    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app_databases"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideProductDao(database: AppDatabase): ProductDao {
        return database.productDao()
    }

    @Provides
    @Singleton
    fun provideProductRepository(
        apiService: ProductApi,
        masterDao: ProductDao
    ): ProductRepository = ProductRepositoryImpl(apiService, masterDao)

    @Provides
    @Singleton
    fun provideFetchProductsUseCase(repository: ProductRepository) = FetchProductsUseCase(repository)

}
