package com.pico.mvvm.timetonic.timetonictest.domain.model.home

data class Doc(
    val id: Int,
    val ext: String,
    val originName: String,
    val internName: String,
    val uuid: String,
    val size: Int,
    val type: String,
    val del: Boolean
)
