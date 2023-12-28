package com.pico.mvvm.timetonic.timetonictest.domain.use_cases.log_in
/**
 *  Here we have the class that has all the use cases for the screen logIn
 */
data class LogInUseCases (
    val createAppKeyCase: CreateAppKeyCase,
    val createOAuthKey: CreateOAuthKey,
    val createSessKeyCase: CreateSessKeyCase
)