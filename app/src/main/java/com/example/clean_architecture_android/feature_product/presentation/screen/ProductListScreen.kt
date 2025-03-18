package com.example.clean_architecture_android.feature_product.presentation.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.clean_architecture_android.data.source.dto.ProductEntity
import com.example.clean_architecture_android.feature_product.presentation.viewmodel.ProductViewModel

@Composable
fun ProductListScreen(
    navController: NavHostController,
    productViewModel: ProductViewModel = hiltViewModel()
) {
    val productList by productViewModel.productList.collectAsState()

    LazyColumn(modifier = Modifier.fillMaxSize().padding(8.dp)) {
        items(productList) { product ->
            ProductItem(product)
        }
    }
}

@Composable
fun ProductItem(product: ProductEntity) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = product.title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Price: $${product.price}",
                fontSize = 16.sp
            )
        }
    }
}
