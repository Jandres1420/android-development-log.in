package com.pico.mvvm.timetonic.timetonictest.presentation.screens.home.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.pico.mvvm.timetonic.timetonictest.domain.model.AllBooksReq
import com.pico.mvvm.timetonic.timetonictest.domain.model.Response
import com.pico.mvvm.timetonic.timetonictest.domain.model.home.Book
import com.pico.mvvm.timetonic.timetonictest.domain.use_cases.home.HomeUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val homeUseCases: HomeUseCases):ViewModel() {

    var allBooksReq by mutableStateOf<Response<AllBooksReq>?>(null)
        private set

    var listOfBooks by mutableStateOf<List<Book>>(listOf())
        private set

    init {
    }

}