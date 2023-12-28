package com.pico.mvvm.timetonic.timetonictest.presentation.screens.home.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.pico.mvvm.timetonic.timetonictest.domain.model.Response
import com.pico.mvvm.timetonic.timetonictest.presentation.components.ProgressBar
import com.pico.mvvm.timetonic.timetonictest.presentation.screens.home.viewModel.HomeViewModel
/**
 *  Is the component that is responsabe for the Response of viewModel.getAllBooksResponse, if its success
 *  it gonna called the component HomeContent(books = viewModel.books)
 *  @param viewModel: LogInViewModel
 */

@Composable
fun GetAllBooksState(viewModel: HomeViewModel = hiltViewModel()) {
    when (val getAllBooksResponse = viewModel.getAllBooksResponse) {
        Response.Loading -> {
            ProgressBar()
        }

        is Response.Success -> {
            Toast.makeText(LocalContext.current, "Info correctly extracted", Toast.LENGTH_LONG).show()
            HomeContent(books = viewModel.books)
        }

        is Response.Failure -> {
            Toast.makeText(
                LocalContext.current,
                getAllBooksResponse.Exception?.message ?: "Error Desconocido",
                Toast.LENGTH_LONG
            ).show()
        }

        else -> {}
    }
}