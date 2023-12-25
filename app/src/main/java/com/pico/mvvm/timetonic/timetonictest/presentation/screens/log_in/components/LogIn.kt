package com.pico.mvvm.timetonic.timetonictest.presentation.screens.log_in.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.pico.mvvm.timetonic.timetonictest.domain.model.Response
import com.pico.mvvm.timetonic.timetonictest.presentation.components.ProgressBar
import com.pico.mvvm.timetonic.timetonictest.presentation.navigation.AppScreen
import com.pico.mvvm.timetonic.timetonictest.presentation.screens.log_in.viewModel.LogInViewModel


@Composable
fun Login(navController: NavHostController, viewModel: LogInViewModel = hiltViewModel()) {
    when (val logInResponse = viewModel.logInResponse) {
        Response.Loading -> {
            ProgressBar()
        }

        is Response.Success -> {
            Toast.makeText(LocalContext.current, "Usuario Logeado", Toast.LENGTH_LONG).show()
            viewModel.createSessKey()
            viewModel.clearState()
            navController.navigate(route = AppScreen.Home.route)
        }

        is Response.Failure -> {
            Toast.makeText(
                LocalContext.current,
                logInResponse.Exception?.message ?: "Error Desconocido",
                Toast.LENGTH_LONG
            ).show()
        }

        else -> {}
    }
}