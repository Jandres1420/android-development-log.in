package com.pico.mvvm.timetonic.timetonictest.presentation.navigation

sealed class AppScreen(val route:String) {
    object Login: AppScreen("login")
    object Home: AppScreen("home")

}