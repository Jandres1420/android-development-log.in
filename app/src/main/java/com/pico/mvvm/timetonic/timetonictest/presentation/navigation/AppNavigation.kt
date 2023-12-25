package com.pico.mvvm.timetonic.timetonictest.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.pico.mvvm.timetonic.timetonictest.presentation.screens.home.HomeScreen
import com.pico.mvvm.timetonic.timetonictest.presentation.screens.log_in.LogInScreen

@Composable
fun AppNavigation(navController: NavHostController){
    NavHost(navController = navController
        , startDestination = AppScreen.Login.route){

        composable(route = AppScreen.Login.route){
            LogInScreen(navController)
        }
        composable(route = AppScreen.Home.route,
            arguments = listOf(navArgument("books"){
                type = NavType.StringType
            })

        ){
            it.arguments?.getString("books")?.let {
                HomeScreen(navController, it )
            }

        }
    }


}