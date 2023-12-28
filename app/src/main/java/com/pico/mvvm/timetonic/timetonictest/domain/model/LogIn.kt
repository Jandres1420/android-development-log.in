package com.pico.mvvm.timetonic.timetonictest.domain.model
/**
 *  Is the dataclass that getsFrom the RetroFit called
 */
data class LogIn (
    val status: String,
    val oauthkey: String,
    val id: String,
    val o_u: String,
    val errorCode : String,
    val errorMsg : String,
    val createdVNB : String,
    val req : String,

)