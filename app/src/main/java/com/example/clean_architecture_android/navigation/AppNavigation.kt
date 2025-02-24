package com.example.clean_architecture_android.navigation

import androidx.navigation.NavController
import androidx.navigation.compose.NavHost

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.clean_architecture_android.feature_splash.SplashScreen

@Composable
fun AppNavigation(navController: NavHostController){

    NavHost(navController=navController,startDestination=Screen.SplashScreen.route){
        composable(Screen.SplashScreen.route) {
            SplashScreen(navController)
        }
    }
}