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

/**
 *  Here we have all the logic of the LogInScreen
 * @param logInUseCases: LogInUseCases using daggerHilt
 */
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
    /**
     *  Since is the first thing that is called when creating de viewModel, called de appKey
     */
    init {
        getAppKey(Constants.VERSION, "createAppkey", "TimetonicPicoApp")
    }

    /**
     *  Here we get the AppKey with an asynchronous called with Retrofit using the usecase.createAppKeyCase
     * @param version: String
     * @param appName: String
     */
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

    /**
     *  Here we get the oauthkey with an asynchronous called with Retrofit and veryfing the status with
     *  the Response state, saving it in  logInResponse that is a mutableStateOf<Response<LogIn>?>
     */
    fun logIn() =
        viewModelScope.launch {
            logInResponse = Response.Loading
            val result = logInUseCases.createOAuthKey(
                version = Constants.VERSION, appKey = appKeyResponse!!.appkey,
                login = state.email, pwd = state.password, req = Constants.CREATEOAUTHKEY
            )
            logInResponse = if(result.status == "nok"){
                Response.Failure(Exception("Error authenticated"))
            }else{
                Response.Success(result)
            }

        }

    /**
     *  Here we get the sessKey with an asynchronous called with Retrofit, using the usecase.createeSessKeyCase
     *   saving it in  allBooksReq that is a mutableStateOf<AllBooksReq>
     */
    fun createSessKey() = viewModelScope.launch {
        try{
            val logInInstance: LogIn? = (logInResponse as? Response.Success<LogIn>)?.data
            val result = logInUseCases.createSessKeyCase(Constants.VERSION, req =  Constants.CREATESESSKEY,
                logInInstance!!.o_u, logInInstance!!.o_u , logInInstance.oauthkey)
            sessKeyResponse = result
            allBooksReq = AllBooksReq(Constants.VERSION, logInInstance!!.o_u, logInInstance!!.o_u, sessKeyResponse!!.sesskey,Constants.GETALLBOOKS)
            allBooksReq?.let {
                encryptedBook = EncryptionUtil.encrypt(it.toJson())
                SharedPreferencesUtil.saveToSharedPreferences(context,"sessionBooks",encryptedBook)
            }

        }catch (e : Exception){
            e.printStackTrace()
        }
    }

    /**
     *   Getting the email every time that it changes like a listener
     */
    fun onEmailInput(email: String) {
        state = state.copy(email = email)
    }

    /**
     *   getting the password every time that it changes like a listener
     */
    fun onPasswordInput(password: String) {
        state = state.copy(password = password)
    }

    /**
     *   Empty de email and password Value
     */
    fun clearState() {
        state = state.copy(
            email = "",
            password = "")
    }
}