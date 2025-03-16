package com.example.clean_architecture_android.navigation
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val route: String, val icon: ImageVector, val title: String) {
    object Home : BottomNavItem("home", Icons.Filled.Home, "Home")
    object shop : BottomNavItem("shop", Icons.Filled.Star, "shop")
    object wishlist : BottomNavItem("wishlist", Icons.Filled.FavoriteBorder, "wishlist")
    object Cart : BottomNavItem("cart", Icons.Filled.ShoppingCart, "Cart")
    object Profile : BottomNavItem("profile", Icons.Filled.Person, "Profile")
    object checkout : BottomNavItem("checkout", Icons.Filled.Person, "checkout")
}
