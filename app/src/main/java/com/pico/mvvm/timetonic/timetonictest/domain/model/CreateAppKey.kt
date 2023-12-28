package com.pico.mvvm.timetonic.timetonictest.domain.model
/**
 *  Is the dataclass that getsFrom the RetroFit called
 */
data class CreateAppKey(
    val status: String,
    val appkey: String,
    val id: String,
    val createdVNB: String,
    val req: String,
)
