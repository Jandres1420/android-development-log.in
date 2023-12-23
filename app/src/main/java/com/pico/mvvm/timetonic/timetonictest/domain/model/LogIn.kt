package com.pico.mvvm.timetonic.timetonictest.domain.model

data class LogIn (
    val status: String,
    val oauthKey: String,
    val id: String,
    val errorCode : String,
    val errorMsg : String,
)