package com.pico.mvvm.timetonic.timetonictest.domain.repository

import com.pico.mvvm.timetonic.timetonictest.domain.model.CreateAppKey
import retrofit2.http.GET

interface LogInRepository {
    @GET("createAppKey")
    suspend fun getAppKey(): CreateAppKey
}