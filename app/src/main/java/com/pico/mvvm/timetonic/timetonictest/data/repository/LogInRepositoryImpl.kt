package com.pico.mvvm.timetonic.timetonictest.data.repository

import com.pico.mvvm.timetonic.timetonictest.domain.model.CreateAppKey
import com.pico.mvvm.timetonic.timetonictest.domain.repository.ApiService
import com.pico.mvvm.timetonic.timetonictest.domain.repository.LogInRepository
import javax.inject.Inject

class LogInRepositoryImpl @Inject constructor(private val apiService: ApiService ):LogInRepository {

    override suspend fun getAppKey(version: String, req: String, appName: String): CreateAppKey {
        return apiService.getAppKey(version,req,appName)
    }

}