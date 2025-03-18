package com.example.clean_architecture_android.navigation
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.clean_architecture_android.feature_product.presentation.screen.ProductListScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomNavItem.Home.route) {
        composable(BottomNavItem.Home.route) { ProductListScreen(navController, hiltViewModel()) }
        composable(BottomNavItem.Home.route) { ProductListScreen(navController, hiltViewModel()) }
        composable(BottomNavItem.Home.route) { ProductListScreen(navController, hiltViewModel()) }
        composable(BottomNavItem.Home.route) { ProductListScreen(navController, hiltViewModel()) }
//        composable(BottomNavItem.shop.route) { ProductListScreen(navController) }
//        composable(BottomNavItem.Cart.route) { ProductListScreen(navController) }
//        composable(BottomNavItem.wishlist.route) { ProductListScreen(navController) }
//        composable(BottomNavItem.Profile.route) { ProductListScreen(navController) }

//        composable("wishlist/{id}") { backStackEntry ->
//            val productId = backStackEntry.arguments?.getString("id") ?: "Unknown"
//            FavouriteScreen(navController)
//        }
//        composable("product_details/{id}") { backStackEntry ->
//            val productId = backStackEntry.arguments?.getString("id") ?: "Unknown"
//            ProductDetailsScreen(navController, productId.toInt(), hiltViewModel())
//        }
//        composable("checkout/{price}/{count}") { backStackEntry ->
//            val price = backStackEntry.arguments?.getString("price")?.toDoubleOrNull() ?: 0.0
//            val count = backStackEntry.arguments?.getString("count")?.toIntOrNull() ?: 0
//            CheckoutScreen(navController, price, count)
//        }

    }
}


