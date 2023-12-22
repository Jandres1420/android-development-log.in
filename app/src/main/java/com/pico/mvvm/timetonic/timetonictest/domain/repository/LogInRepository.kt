package com.pico.mvvm.timetonic.timetonictest.domain.repository

import com.pico.mvvm.timetonic.timetonictest.domain.model.CreateAppKey
import retrofit2.http.GET
import retrofit2.http.Query

interface LogInRepository {
    suspend fun getAppKey(version: String, req: String, appName: String): CreateAppKey
}