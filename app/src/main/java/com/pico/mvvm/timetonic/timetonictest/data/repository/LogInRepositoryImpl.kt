package com.pico.mvvm.timetonic.timetonictest.data.repository

import com.pico.mvvm.timetonic.timetonictest.domain.model.CreateAppKey
import com.pico.mvvm.timetonic.timetonictest.domain.repository.LogInRepository
import javax.inject.Inject

class LogInRepositoryImpl @Inject constructor():LogInRepository {
    override suspend fun getAppKey(): CreateAppKey {
        TODO("Not yet implemented")
    }
}