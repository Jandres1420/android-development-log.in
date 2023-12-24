package com.pico.mvvm.timetonic.timetonictest.domain.model

data class CreateSessKey(
    val status: String,
    val sesskey: String,
    val id: String,
    val createdVNB: String,
    val req: String,
)