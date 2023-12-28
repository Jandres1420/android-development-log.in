package com.pico.mvvm.timetonic.timetonictest.presentation.screens.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.pico.mvvm.timetonic.timetonictest.presentation.components.TopTimetonic
import com.pico.mvvm.timetonic.timetonictest.presentation.screens.home.components.GetAllBooksState
import com.pico.mvvm.timetonic.timetonictest.presentation.screens.home.components.HomeContent
import com.pico.mvvm.timetonic.timetonictest.presentation.screens.home.viewModel.HomeViewModel
import com.pico.mvvm.timetonic.timetonictest.utils.SharedPreferencesUtil
/**
 *  Shows screen in a Scaffold with  topbar, content, bottom bar, it also have another
 * component called GetAllBooksState, which need the viewModel to see if the info is already loaded
 * @param navController: NavHostController (for switching between screens).
 */
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen (navController: NavHostController?,viewModel: HomeViewModel = hiltViewModel()){
    val context = LocalContext.current
    Scaffold (
        topBar = { TopTimetonic() },
        content = { GetAllBooksState(viewModel) },
        bottomBar = {}
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    HomeScreen(null)
}