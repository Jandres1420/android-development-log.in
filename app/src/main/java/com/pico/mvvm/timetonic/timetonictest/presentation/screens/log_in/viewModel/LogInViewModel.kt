package com.pico.mvvm.timetonic.timetonictest.presentation.screens.log_in.viewModel

import android.util.Log
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pico.mvvm.timetonic.timetonictest.core.Constants
import com.pico.mvvm.timetonic.timetonictest.domain.model.CreateAppKey
import com.pico.mvvm.timetonic.timetonictest.domain.model.CreateSessKey
import com.pico.mvvm.timetonic.timetonictest.domain.model.LogIn
import com.pico.mvvm.timetonic.timetonictest.domain.model.Response
import com.pico.mvvm.timetonic.timetonictest.domain.use_cases.log_in.CreateOAuthKey
import com.pico.mvvm.timetonic.timetonictest.domain.use_cases.log_in.CreateSessKeyCase
import com.pico.mvvm.timetonic.timetonictest.domain.use_cases.log_in.LogInUseCases
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LogInViewModel @Inject constructor(private val logInUseCases: LogInUseCases) : ViewModel() {

    var state by mutableStateOf(LogInState())
    var appKeyResponse by mutableStateOf<CreateAppKey?>(null)
        private set

    var logInResponse by mutableStateOf<Response<LogIn>?>(null)
        private set


    var sessKeyResponse by mutableStateOf<CreateSessKey?>(null)
        private set
    init {
        getAppKey("1.0", "createAppkey", "TimetonicPicoApp")
    }

    fun getAppKey(version: String, req: String, appName: String) {
        viewModelScope.launch {
            try {
                val result = logInUseCases.createAppKeyCase(version, req, appName)
                appKeyResponse = result
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun logIn() =
        viewModelScope.launch {
            logInResponse = Response.Loading
            val result = logInUseCases.createOAuthKey(
                version = "1.1", appKey = appKeyResponse!!.appkey,
                login = state.email, pwd = state.password, req = Constants.CREATEOAUTHKEY
            )
            logInResponse = if(result.status == "nok"){
                Response.Failure(Exception("Error authenticated"))
            }else{
                Response.Success(result)
            }

        }

    fun createSessKey() = viewModelScope.launch {
        try{
            val logInInstance: LogIn? = (logInResponse as? Response.Success<LogIn>)?.data
            Log.d("LogInViewModel", "Usuario: $logInInstance")
            val result = logInUseCases.createSessKeyCase(version = "1.0", req =  Constants.CREATESESSKEY,
                logInInstance!!.o_u, logInInstance.id, logInInstance.oauthkey)
            sessKeyResponse = result
        }catch (e : Exception){
            e.printStackTrace()
        }

    }


    fun onEmailInput(email: String) {
        state = state.copy(email = email)
    }

    fun onPasswordInput(password: String) {
        state = state.copy(password = password)
    }

    fun clearState() {
        state = state.copy(
            email = "",
            password = "")
    }
}