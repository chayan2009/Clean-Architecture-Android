package com.example.clean_architecture_android.di

import com.example.clean_architecture_android.data.repository.ProductRepositoryImpl
import com.example.clean_architecture_android.data.source.api.ProductApi
import com.example.clean_architecture_android.domain.repository.ProductRepository
import com.example.clean_architecture_android.domain.usecase.GetProductsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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
        .baseUrl("https://fakestoreapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ProductApi =
        retrofit.create(ProductApi::class.java)

    @Provides
    @Singleton
    fun provideProductRepository(api: ProductApi): ProductRepository =
        ProductRepositoryImpl(api)

    @Provides
    @Singleton
    fun provideProductUseCase(repository: ProductRepository): GetProductsUseCase =
        GetProductsUseCase(repository)
}
