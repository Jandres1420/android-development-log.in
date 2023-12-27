package com.pico.mvvm.timetonic.timetonictest.presentation.screens.log_in.viewModel

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import java.util.Base64
import androidx.annotation.RequiresApi
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pico.mvvm.timetonic.timetonictest.core.Constants
import com.pico.mvvm.timetonic.timetonictest.domain.model.AllBooksReq
import com.pico.mvvm.timetonic.timetonictest.domain.model.CreateAppKey
import com.pico.mvvm.timetonic.timetonictest.domain.model.CreateSessKey
import com.pico.mvvm.timetonic.timetonictest.domain.model.LogIn
import com.pico.mvvm.timetonic.timetonictest.domain.model.Response
import com.pico.mvvm.timetonic.timetonictest.domain.use_cases.log_in.LogInUseCases
import com.pico.mvvm.timetonic.timetonictest.utils.EncryptionUtil
import com.pico.mvvm.timetonic.timetonictest.utils.SharedPreferencesUtil
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.security.Key
import javax.crypto.Cipher
import javax.inject.Inject

@HiltViewModel
class LogInViewModel @Inject constructor(private val logInUseCases: LogInUseCases,
    @ApplicationContext private val context: Context) : ViewModel() {

    var state by mutableStateOf(LogInState())
    var appKeyResponse by mutableStateOf<CreateAppKey?>(null)
        private set

    var logInResponse by mutableStateOf<Response<LogIn>?>(null)
        private set


    var sessKeyResponse by mutableStateOf<CreateSessKey?>(null)
        private set

    var allBooksReq by mutableStateOf<AllBooksReq?>(null)
        private set

    var encryptedBook by mutableStateOf("")

    init {
        getAppKey("1.0", "createAppkey", "TimetonicPicoApp")
    }


    @RequiresApi(Build.VERSION_CODES.O)
    fun encrypt(input: String, key: Key): String {
        val cipher = Cipher.getInstance("AES")
        cipher.init(Cipher.ENCRYPT_MODE, key)
        val encryptedBytes = cipher.doFinal(input.toByteArray())
        return Base64.getEncoder().encodeToString(encryptedBytes)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun decrypt(input: String, key: Key): String {
        val cipher = Cipher.getInstance("AES")
        cipher.init(Cipher.DECRYPT_MODE, key)
        val decodedBytes = Base64.getDecoder().decode(input)
        val decryptedBytes = cipher.doFinal(decodedBytes)
        return String(decryptedBytes)
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

    @SuppressLint("NewApi")
    fun createSessKey() = viewModelScope.launch {
        try{
            val logInInstance: LogIn? = (logInResponse as? Response.Success<LogIn>)?.data
            val result = logInUseCases.createSessKeyCase(version = "1.0", req =  Constants.CREATESESSKEY,
                logInInstance!!.o_u, logInInstance!!.o_u , logInInstance.oauthkey)
            sessKeyResponse = result
            allBooksReq = AllBooksReq("1.0", logInInstance!!.o_u, logInInstance!!.o_u, sessKeyResponse!!.sesskey,Constants.GETALLBOOKS)
            allBooksReq?.let {
                encryptedBook = EncryptionUtil.encrypt(it.toJson())
                SharedPreferencesUtil.saveToSharedPreferences(context,"sessionBooks",encryptedBook)
            }

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