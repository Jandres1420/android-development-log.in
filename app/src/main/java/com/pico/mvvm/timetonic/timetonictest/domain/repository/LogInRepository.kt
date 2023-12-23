package com.pico.mvvm.timetonic.timetonictest.domain.repository

import com.pico.mvvm.timetonic.timetonictest.domain.model.CreateAppKey
import com.pico.mvvm.timetonic.timetonictest.domain.model.LogIn
import com.pico.mvvm.timetonic.timetonictest.domain.model.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface LogInRepository {
    suspend fun getAppKey(version: String, req: String, appName: String): CreateAppKey

    suspend fun logIn(version: String, login : String, pwd : String, appKey : String, req: String): LogIn
}