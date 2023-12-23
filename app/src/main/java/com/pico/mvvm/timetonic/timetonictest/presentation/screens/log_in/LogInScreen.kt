package com.pico.mvvm.timetonic.timetonictest.presentation.screens.log_in

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.pico.mvvm.timetonic.timetonictest.presentation.components.TopTimetonic
import com.pico.mvvm.timetonic.timetonictest.presentation.screens.log_in.components.LogInBottomBar
import com.pico.mvvm.timetonic.timetonictest.presentation.screens.log_in.components.LogInContent
import com.pico.mvvm.timetonic.timetonictest.presentation.screens.log_in.components.Login

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LogInScreen(navController: NavHostController){
    Scaffold(
        topBar = { TopTimetonic() },
        content = { LogInContent(navController)},
        bottomBar = { LogInBottomBar()}
    )
    Login(navController)
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
//    LogInScreen()
}