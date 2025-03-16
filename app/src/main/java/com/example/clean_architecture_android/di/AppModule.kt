package com.example.clean_architecture_android.di

import android.content.Context
import androidx.room.Room
import com.example.clean_architecture_android.core.database.AppDatabase
import com.example.clean_architecture_android.data.db.ProductDao
import com.example.clean_architecture_android.data.repository.ProductRepositoryImpl
import com.example.clean_architecture_android.data.source.api.ProductApi
import com.example.ecommerce_app.core.common.Constants
import com.example.clean_architecture_android.domain.repository.ProductRepository
import com.example.clean_architecture_android.domain.usecase.GetProductsUseCase
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
    fun provideProductRepository(api: ProductApi, productDao: ProductDao): ProductRepository =
        ProductRepositoryImpl(api,productDao)

    @Provides
    @Singleton
    fun provideProductUseCase(repository: ProductRepository): GetProductsUseCase =
        GetProductsUseCase(repository)

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "food"
        ).build()
    }
    @Provides
    @Singleton
    fun provideProductDao(db: AppDatabase): ProductDao = db.productDao()


}
