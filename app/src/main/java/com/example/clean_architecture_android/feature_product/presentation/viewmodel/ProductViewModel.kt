package com.example.clean_architecture_android.feature_product.presentation.viewmodel

import com.example.clean_architecture_android.domain.usecase.FetchProductsUseCase


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clean_architecture_android.data.source.dto.ProductEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val fetchProductsUseCase: FetchProductsUseCase
) : ViewModel() {

    private val _productList = MutableStateFlow<List<ProductEntity>>(emptyList())
    val productList: StateFlow<List<ProductEntity>> = _productList

    init {
        viewModelScope.launch {
            fetchProductsUseCase().collect { products ->
                _productList.value = products
            }
        }
    }
}

