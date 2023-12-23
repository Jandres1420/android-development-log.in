package com.pico.mvvm.timetonic.timetonictest.data.repository

import com.pico.mvvm.timetonic.timetonictest.domain.model.CreateAppKey
import com.pico.mvvm.timetonic.timetonictest.domain.model.LogIn
import com.pico.mvvm.timetonic.timetonictest.domain.model.Response
import com.pico.mvvm.timetonic.timetonictest.domain.repository.ApiService
import com.pico.mvvm.timetonic.timetonictest.domain.repository.LogInRepository
import javax.inject.Inject
import kotlin.math.log

class LogInRepositoryImpl @Inject constructor(private val apiService: ApiService ):LogInRepository {

    override suspend fun getAppKey(version: String, req: String, appName: String): CreateAppKey {
        return apiService.getAppKey(version,req,appName)
    }

    override suspend fun logIn(version: String, login: String, pwd: String, appKey: String, req: String): LogIn {
        return apiService.login(version, login, pwd, appKey, req)
    }

}