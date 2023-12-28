package com.pico.mvvm.timetonic.timetonictest.presentation.navigation

/**
 * Calcula la suma de dos números enteros.
 *
 * @param route: String
 * @return AppScreen(route).
 */
sealed class AppScreen(val route:String) {
    object Login: AppScreen("login")
    object Home: AppScreen("home")

}