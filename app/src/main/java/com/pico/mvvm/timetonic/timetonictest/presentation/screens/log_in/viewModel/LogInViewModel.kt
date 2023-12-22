package com.pico.mvvm.timetonic.timetonictest.presentation.screens.log_in.viewModel

import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.pico.mvvm.timetonic.timetonictest.domain.use_cases.log_in.LogInUseCases
import javax.inject.Inject

@HiltViewModel
class LogInViewModel @Inject constructor(private val logInUseCases: LogInUseCases) : ViewModel() {

    var state by mutableStateOf(LogInState())
    fun onEmailInput(email:String){
        state = state.copy(email = email)
    }
    fun onPasswordInput(password:String){
        state = state.copy(password = password)
    }
}