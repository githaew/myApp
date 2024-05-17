package com.jane.malkia.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jane.malkia.ui.theme.Screens.about.HomeContent
import com.jane.malkia.ui.theme.Screens.login.LoginScreen
import com.jane.malkia.ui.theme.Screens.logout.LogoutScreen
import com.jane.malkia.ui.theme.Screens.products.AddProductsScreen
import com.jane.malkia.ui.theme.Screens.products.UpdateProductsScreen
import com.jane.malkia.ui.theme.Screens.products.ViewProductsScreen
import com.jane.malkia.ui.theme.Screens.products.ViewUploadsScreen
import com.jane.malkia.ui.theme.Screens.registration.RegisterScreen


@Composable
fun AppNavHost(modifier: Modifier = Modifier,
               navController : NavHostController = rememberNavController(),
               startDestination: String= ROUTE_ABOUT_SCREEN){
    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = startDestination
    ){

        composable(ROUTE_ABOUT_SCREEN) {
            HomeContent(navController)
        }
        composable(ROUTE_REGISTER_SCREEN) {
            RegisterScreen(navController)
        }
        composable(route = ROUTE_LOGIN_SCREEN) {
            LoginScreen(navController)
        }
        composable(ROUTE_LOGOUT) {
            LogoutScreen(navController)
        }
        composable(ROUTE_VIEW_UPLOAD){
            ViewUploadsScreen(navController)
        }
        composable(ROUTE_ADD_PRODUCT){
            AddProductsScreen(navController)
        }
        composable(ROUTE_UPDATE_PRODUCT+ "/{id}"){passedData ->
            UpdateProductsScreen(navController,passedData.arguments?.getString("id")!!)
        }
//        composable(ROUTE_UPDATE_PRODUCT){
//            UpdateProductsScreen(navController)
//        }
        composable(ROUTE_VIEW_PRODUCT){
            ViewProductsScreen(navController)
        }
    }
}