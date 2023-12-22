package com.pico.mvvm.timetonic.timetonictest.domain.use_cases.log_in

import com.pico.mvvm.timetonic.timetonictest.domain.repository.LogInRepository

class CreateAppKeyCase constructor(private val repository: LogInRepository){

    suspend operator fun invoke(version: String, appName: String, req: String ) = repository.getAppKey(version,appName,req)

}