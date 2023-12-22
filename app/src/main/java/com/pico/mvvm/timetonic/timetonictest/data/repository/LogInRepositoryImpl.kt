package com.pico.mvvm.timetonic.timetonictest.data.repository

import com.pico.mvvm.timetonic.timetonictest.domain.model.CreateAppKey
import com.pico.mvvm.timetonic.timetonictest.domain.repository.LogInRepository

class LogInRepositoryImpl:LogInRepository {
    override suspend fun getAppKey(): CreateAppKey {
        TODO("Not yet implemented")
    }
}