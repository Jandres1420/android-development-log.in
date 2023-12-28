package com.pico.mvvm.timetonic.timetonictest.data.repository

import com.pico.mvvm.timetonic.timetonictest.domain.model.CreateAppKey
import com.pico.mvvm.timetonic.timetonictest.domain.model.CreateSessKey
import com.pico.mvvm.timetonic.timetonictest.domain.model.LogIn
import com.pico.mvvm.timetonic.timetonictest.domain.model.Response
import com.pico.mvvm.timetonic.timetonictest.domain.repository.ApiService
import com.pico.mvvm.timetonic.timetonictest.domain.repository.LogInRepository
import javax.inject.Inject
import kotlin.math.log
/**
 *  Its gonna be the implementetation of the LogInRepository with all their methods and the direct conecctiong with apiService
 *  that is responsable for the calls with Retrofit
 *  @param apiService
 */
class LogInRepositoryImpl @Inject constructor(private val apiService: ApiService ):LogInRepository {

    /**
     *  Is responsible for handling calls with Retrofit getting the AppKey
     *  and getting a data class CreateAppKey
     *  @param version: String
     *  @param req: String
     *  @param appName: String
     *  @return CreateAppKey
     */
    override suspend fun getAppKey(version: String, req: String, appName: String): CreateAppKey {
        return apiService.getAppKey(version,req,appName)
    }

    /**
     *  Is responsible for handling calls with Retrofit getting the oauthkey
     *  and getting a data class LogIn
     *  @param version: String
     *  @param login: String
     *  @param pwd: String
     *  @param appKey: String
     *  @param req: String
     *  @return LogIn
     */
    override suspend fun logIn(version: String, login: String, pwd: String, appKey: String, req: String): LogIn {
        return apiService.login(version, login, pwd, appKey, req)
    }

    /**
     *  Is responsible for handling calls with Retrofit getting the sessionKey
     *  and getting a data class CreateSessKey
     *  @param version: String
     *  @param req: String
     *  @param o_u: String
     *  @param u_c: String
     *  @param req: String
     *  @param oauthkey: String
     *  @return CreateSessKey
     */
    override suspend fun createSessKey(
        version: String,
        req: String,
        o_u: String,
        u_c: String,
        oauthkey: String
    ): CreateSessKey {
        return apiService.createSessKey(version,req,o_u,u_c,oauthkey)
    }

}