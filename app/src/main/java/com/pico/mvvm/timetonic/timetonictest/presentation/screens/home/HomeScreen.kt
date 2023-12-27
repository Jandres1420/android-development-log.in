package com.pico.mvvm.timetonic.timetonictest.presentation.screens.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.pico.mvvm.timetonic.timetonictest.presentation.components.TopTimetonic
import com.pico.mvvm.timetonic.timetonictest.utils.SharedPreferencesUtil

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen (navController: NavHostController?){
    val context = LocalContext.current
    Scaffold (
        topBar = { TopTimetonic() },
        content = { Text(text = SharedPreferencesUtil.readFromSharedPreferences(context,"sessionBooks","")) },
        bottomBar = {}
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    HomeScreen(null)
}