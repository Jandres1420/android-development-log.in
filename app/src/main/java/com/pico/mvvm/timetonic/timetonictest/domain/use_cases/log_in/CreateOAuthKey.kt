package com.pico.mvvm.timetonic.timetonictest.domain.use_cases.log_in

import com.pico.mvvm.timetonic.timetonictest.domain.repository.LogInRepository

class CreateOAuthKey constructor(private val repository: LogInRepository) {
    suspend operator fun invoke(version: String, login : String, pwd : String, appKey : String, req: String) =
        repository.logIn(version, login, pwd, appKey, req)

}