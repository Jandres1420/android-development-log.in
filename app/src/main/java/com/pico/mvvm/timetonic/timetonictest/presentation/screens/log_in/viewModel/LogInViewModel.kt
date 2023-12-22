package com.pico.mvvm.timetonic.timetonictest.presentation.screens.log_in.viewModel

import android.util.Log
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pico.mvvm.timetonic.timetonictest.domain.model.CreateAppKey
import com.pico.mvvm.timetonic.timetonictest.domain.use_cases.log_in.LogInUseCases
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LogInViewModel @Inject constructor(private val logInUseCases: LogInUseCases) : ViewModel() {

    var state by mutableStateOf(LogInState())
    var appKeyResponse by mutableStateOf<CreateAppKey?>(null)
    private set
    init {
        getAppKey("1.0","createAppkey","TimetonicPicoApp")
    }

    fun getAppKey(version: String, req: String, appName: String) {
        viewModelScope.launch {
            try {
                val result = logInUseCases.createAppKeyCase(version, req, appName)
                appKeyResponse = result
                Log.d("LogInViewModel", "appkey: $appKeyResponse")
            } catch (e: Exception) {
                // Manejar el error según tus necesidades
                e.printStackTrace()
            }
        }
    }

    fun onEmailInput(email:String){
        state = state.copy(email = email)
    }
    fun onPasswordInput(password:String){
        state = state.copy(password = password)
    }
}