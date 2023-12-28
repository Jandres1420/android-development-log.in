package com.pico.mvvm.timetonic.timetonictest.domain.model
/**
 *  Is the dataclass that getsFrom the RetroFit called
 */
data class CreateSessKey(
    val status: String,
    val sesskey: String,
    val id: String,
    val createdVNB: String,
    val req: String,
)